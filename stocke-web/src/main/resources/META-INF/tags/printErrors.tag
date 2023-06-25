<%--
<%@ tag language="java" pageEncoding="UTF-8" %>

<%@tag import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%if(!SessionErrors.isEmpty(renderRequest)){ %>
<%for(String key:SessionErrors.keySet(renderRequest)){ %>
<liferay-ui:error key="<%=key %>" message="<%=key %>"/>
<%}	%>
<%} %>--%>
