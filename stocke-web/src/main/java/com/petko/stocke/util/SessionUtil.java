package com.petko.stocke.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.servlet.PortalSessionContext;
import com.petko.stocke.constants.Keys;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Slf4j
public class SessionUtil {


    /**
     * Getting an organization from a session
     * @param request
     * @return
     */
    public static Optional<Organization> getSessionOrgId(HttpServletRequest request){
        Organization org = null;
        if(!SessionUtil.getParam(request.getRequestedSessionId(), Keys.API.SESSION_ORG_ID).isEmpty()) {
            Long orgId = (Long) SessionUtil.getParam(request.getRequestedSessionId(), Keys.API.SESSION_ORG_ID).get();
            try {
                org = OrganizationLocalServiceUtil.getOrganization(orgId);
            } catch (PortalException e) {
                log.error("Ошибка получения организации выдачи угольной продукции ", e);
                e.printStackTrace();
            }
        }
        return Optional.ofNullable(org);
    }

    /**
     * Getting an organization from a session
     * @param sessionId
     * @param param
     * @return
     */
    private static Optional<Object> getParam(String sessionId, String param) {
        if (sessionId != null && !sessionId.isBlank()) {
            try {
                HttpSession rootContextUserSession = PortalSessionContext.get(sessionId);
                return Optional.ofNullable(rootContextUserSession.getAttribute(param));
            } catch (Exception var3) {
                log.debug("Error getting param - " + param + ", for session id - " + sessionId);
            }
        }

        return Optional.empty();
    }
}
