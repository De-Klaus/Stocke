package com.petko.stocke.portlet;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.osgi.service.component.annotations.Component;
import com.petko.stocke.constants.WebKeys;
import com.petko.stocke.service.HumanApplicationService;
import com.petko.stocke.util.ProduceProductUtil;

import javax.portlet.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;


/**
 * @author Petko
 *
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=Продукция",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/js/main.js",
                "com.liferay.portlet.header-portlet-javascript=/js/jquery.inputmask.bundle.min.js?js_fast_load=0",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Выдача продукции",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/delivery/view.jsp",
                "javax.portlet.name=" + WebKeys.DELIVERY_NAME,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)

@Slf4j
public class DeliveryPortlet extends MVCPortlet {


    @Override
    public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        log.info("Start Render Delivery .......");
        super.render(request, response);
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response)
            throws IOException, PortletException {
        log.info("Start Resource Delivery ......." );
        String resourceID = request.getResourceID();
        log.info("Resource id=" + resourceID);
        switch (resourceID) {
            case "produceAdd":
                break;
            default:
                log.error("Can't find metod");
                break;
        }
        super.serveResource(request, response);
    }

    /**
     * <p> Issuance of products </p>
     *
     * @param request
     * @param response
     */
    public void produceProduct(ActionRequest request, ActionResponse response) throws PortalException {
        String addLimit = ParamUtil.getString(request, WebKeys.Delivery.Request.ADD_LIMIT);
        String recipientId = ParamUtil.getString(request, WebKeys.Delivery.Request.ID);
        String storekeeperId = ParamUtil.getString(request, WebKeys.Delivery.Request.STOREKEEPER_ID);
        String orgId = ParamUtil.getString(request, WebKeys.Delivery.Request.ORG_ID);
        String userId = ParamUtil.getString(request, WebKeys.Delivery.Request.USER_ID);
        String gradesItem = ParamUtil.getString(request, WebKeys.Delivery.Request.GRADES);

        // Data transfer for issuance
        long aprove = HumanApplicationService.approve(Map.of(
                "recipientId",recipientId,
                "addLimit",addLimit,
                "storekeeperId",storekeeperId,
                "orgId",orgId,
                "userId",userId,
                "gradesItem",gradesItem
                ));

        // Data transfer to fix the issue of products from the warehouse
        ProduceProductUtil.prodeceProductGrades(Long.parseLong(orgId),
                Long.parseLong(gradesItem),
                BigDecimal.valueOf(Double.parseDouble(addLimit)));

        // redirect
        MutableRenderParameters parameters = response.getRenderParameters();
        parameters.setValue(WebKeys.Delivery.APROVE, aprove+"");
        parameters.setValue("mvcPath", "/jsp/delivery/statement.jsp");
    }

    /**
     * <p> Applicant Search </p>
     *
     * @param request
     * @param response
     */
    public void serchRecords(ActionRequest request, ActionResponse response) throws PortalException {
        long humanId = 0;
        String snils = errorSerch(request,ParamUtil.getString(request, WebKeys.Delivery.Request.SNILS_S),"snils");
        String lastname = errorSerch(request,ParamUtil.getString(request, WebKeys.Delivery.Request.LASTNAME_S),"lastname");
        String firstname = errorSerch(request,ParamUtil.getString(request, WebKeys.Delivery.Request.FIRSTNAME_S),"firstname");
        String middlename = errorSerch(request,ParamUtil.getString(request, WebKeys.Delivery.Request.MIDDLENAME_S),"middlename");
        String birthdate = errorSerch(request,ParamUtil.getString(request, WebKeys.Delivery.Request.BIRTHDATE_S),"birthdate");

        if(snils!=null&&!snils.trim().isEmpty()){
            humanId= HumanApplicationService.findIdBySnils(snils);
        }
        if(humanId==0||(humanId+"").equals("9223372036854775807")){
            humanId= HumanApplicationService.findByFioAndBirthDay(lastname,firstname,middlename,birthdate);
        }
        if(humanId!=0)
            SessionErrors.clear(request);

        MutableRenderParameters parameters = response.getRenderParameters();
        parameters.setValue(WebKeys.Delivery.HUMAN_ID, humanId+"");
    }

    /**
     * <p>Checking fields from the form for errors and writing them to the session </p>
     *
     * @param request
     * @param stringRequest - значени поля типа String
     * @param errorName - key error
     */
    private String errorSerch(ActionRequest request, String stringRequest, String errorName) {
        if(stringRequest==null||stringRequest.trim().isEmpty())
            SessionErrors.add(request, errorName);
        return stringRequest;
    }

}