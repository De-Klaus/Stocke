package com.petko.stocke.portlet;


import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.petko.stocke.constants.Keys.API;
import com.petko.stocke.constants.WebKeys;
import com.petko.stocke.pool.RecordPersonalPool;
import com.petko.stocke.service.SaveFileService;
import com.petko.stocke.util.PdfUtil;
import lombok.extern.slf4j.Slf4j;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author PetkoN
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
                "javax.portlet.display-name=Личный кабинет физического лица",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/personal/view.jsp",
                "javax.portlet.name=" + WebKeys.PERSONAL_NAME,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
@Slf4j
public class PersonalPortlet extends MVCPortlet {
    private static SimpleDateFormat sdftz = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

    @Override
    public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
        log.info("Start Render Persona .......");
        super.render(request, response);
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response)
            throws IOException, PortletException {
        log.info("Start Resource Persona ......." );
        String resourceID = request.getResourceID();
        log.info("Resource id=" + resourceID);
        switch (resourceID) {
            case "download":
                downloadPersonalQr(request,response);
                break;
            default:
                log.error("Can't find metod");
                break;
        }
        super.serveResource(request, response);
    }


    /**
     * Download personal pdf file
     * @param request
     * @param response
     */
    public void downloadPersonalQr(ResourceRequest request, ResourceResponse response) {
        log.info("Downloading personal");

        long humanId = ParamUtil.getLong(request, API.HUMAN_ID);
        log.info(String.valueOf(humanId));

        RecordPersonalPool params = new RecordPersonalPool(humanId);
        log.info("downloadPersonalQr");

        // TODO file generation
        byte[] pdfQrBytes = PdfUtil.createPdfPersonal(params.getCreateParams());

        // TODO file saving
        SaveFileService.collectPdfQrDoc(request,response,params.getSaveFileParams(),pdfQrBytes);
    }


}