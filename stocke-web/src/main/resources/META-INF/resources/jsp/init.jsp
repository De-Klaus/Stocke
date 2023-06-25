<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib prefix="clay" uri="http://liferay.com/tld/clay" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend"  %>

<%@ page import="javax.portlet.PortletURL" %><%@
        page import="com.liferay.portal.kernel.util.GetterUtil" %><%@
        page import="com.liferay.portal.kernel.util.ParamUtil" %><%@
        page import="com.liferay.portal.kernel.log.Log" %><%@
        page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@ page import="java.util.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.ResourceBundle" %>




<liferay-theme:defineObjects />
<liferay-frontend:defineObjects />
<portlet:defineObjects />
<%
 String curPortletNameSpace = themeDisplay.getPortletDisplay().getNamespace();
%>