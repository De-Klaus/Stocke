package com.petko.stocke.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.petko.stocke.constants.WebKeys;
import lombok.extern.slf4j.Slf4j;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;


@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=Продукция",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.header-portlet-javascript=/js/main.js",
                "com.liferay.portlet.header-portlet-javascript=/js/jquery.inputmask.bundle.min.js?js_fast_load=0",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=Отчётность",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/jsp/statistic/main.jsp",
                "javax.portlet.name=" + WebKeys.STATISTIC_NAME,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
@Slf4j
public class StatisticPortlet extends MVCPortlet {

        @Override
        public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {
                log.info("Start Render .......");
                super.render(request, response);
        }




}
