package com.petko.stocke.portlet;


import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.osgi.service.component.annotations.Component;
import com.petko.stocke.constants.WebKeys;
import com.petko.stocke.util.CamundaUtil;
import com.petko.stocke.util.ProduceCoalUtil;

import javax.portlet.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;


/**
 * @author PetkoN
 *
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=Угольная продукция",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/js/main.js",
                "com.liferay.portlet.header-portlet-javascript=/js/jquery.inputmask.bundle.min.js?js_fast_load=0",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Выдача угольной продукции",
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
     * <p> Выдача угольной продукции.
     * Номер aprove заявления передаём в redirect. </p>
     *
     * @param request
     * @param response
     */
    public void produceCoal(ActionRequest request, ActionResponse response) throws PortalException {
        String addLimit = ParamUtil.getString(request, WebKeys.Delivery.Request.ADD_LIMIT);
        String remaining_limit = ParamUtil.getString(request, WebKeys.Delivery.Request.REMAINING_LIMIT);
        String recipientId = ParamUtil.getString(request, WebKeys.Delivery.Request.ID);
        String storekeeperId = ParamUtil.getString(request, WebKeys.Delivery.Request.STOREKEEPER_ID);
        String orgId = ParamUtil.getString(request, WebKeys.Delivery.Request.ORG_ID);
        String userId = ParamUtil.getString(request, WebKeys.Delivery.Request.USER_ID);
        String gradesItem = ParamUtil.getString(request, WebKeys.Delivery.Request.GRADES);

        // Передача данных на выдачу угля физику
        long aprove = CamundaUtil.approve(Map.of(
                "recipientId",recipientId,
                "addLimit",addLimit,
                "storekeeperId",storekeeperId,
                "orgId",orgId,
                "userId",userId,
                "gradesItem",gradesItem
                ));

        // Передача данных на фиксацию выданного угля со склада
        ProduceCoalUtil.prodeceCaolGrades(Long.parseLong(orgId),
                Long.parseLong(gradesItem),
                BigDecimal.valueOf(Double.parseDouble(addLimit)));

        // передача параметров и redirect
        MutableRenderParameters parameters = response.getRenderParameters();
        parameters.setValue(WebKeys.Delivery.APROVE, aprove+"");
        parameters.setValue("mvcPath", "/jsp/delivery/statement.jsp");
    }

    /**
     * <p> Поиск заявителя в БД. Поиск осуществляется по СНИЛС и ФИО с датой рождения </p>
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
        log.info("birthdate "+ birthdate+"snils "+snils+"lastname "+lastname+"firstname "+firstname+"middlename "+middlename);
        log.info("SessionErrors "+ SessionErrors.isEmpty(request));

        if(snils!=null&&!snils.trim().isEmpty()){
            humanId=CamundaUtil.findIdBySnils(snils);
            log.info("snils_humanId: "+humanId);
        }
        if(humanId==0||(humanId+"").equals("9223372036854775807")){
            humanId=CamundaUtil.findByFIOandBirthDay(lastname,firstname,middlename,birthdate);
            log.info("FIO_humanId: "+humanId);
        }
        if(humanId!=0)
            SessionErrors.clear(request); // оситка ссесии при успешно поиске

        MutableRenderParameters parameters = response.getRenderParameters();
        parameters.setValue(WebKeys.Delivery.HUMAN_ID, humanId+"");
    }

    /**
     * <p> Проверка послей из формы на наличие ошибок и запись их в ссесию </p>
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