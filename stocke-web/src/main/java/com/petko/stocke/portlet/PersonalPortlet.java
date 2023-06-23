package com.petko.stocke.portlet;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.*;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import com.petko.stocke.constants.WebKeys;
import com.petko.stocke.pool.RecordPersonalPool;
import com.petko.stocke.service.SaveFileService;
import com.petko.stocke.util.PdfUtil;

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
                "com.liferay.portlet.display-category=Угольная продукция",
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
        super.serveResource(request, response);
    }





    /**
     * Download personal pdf file
     * @param request
     * @param response
     */
    public void downloadPersonalQr(ActionRequest request, ActionResponse response) throws IOException, InterruptedException {
        log.info("Downloading personal");

        long humanId = ParamUtil.getLong(request,"humanId");
        log.info(String.valueOf(humanId));

        RecordPersonalPool params = new RecordPersonalPool(humanId);
        log.info("downloadPersonalQr");

        // TODO формирование файла
        byte[] pdfQrBytes = PdfUtil.createPdfPersonal(params.getCreateParams());

        // TODO сохранение файла
        JSONObject jsonObject =SaveFileService.collectPdfQrDoc(params.getSaveFileParams(),pdfQrBytes);

        // TODO запускаем скачивание файла
        if(jsonObject.has("url")){
            String url = jsonObject.getString("url");
            response.sendRedirect(url);
        }


    }


}