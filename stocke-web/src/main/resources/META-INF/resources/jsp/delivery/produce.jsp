<%@ page import="com.petko.stocke.dto.HumanDto" %>
<%@ page import="com.petko.stocke.constants.WebKeys" %>
<%@ page import="com.petko.stocke.service.HumanApplicationService" %>
<%@ page import="com.petko.stocke.util.ProduceProductUtil" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.liferay.portal.kernel.model.Organization" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.petko.stocke.dto.GradeProductDto" %>
<%@ page import="com.liferay.portal.kernel.service.UserLocalServiceUtil" %>
<%@ page import="com.petko.stocke.constants.Keys" %>
<%@ page import="com.petko.stocke.util.SessionUtil" %>
<%@ page import="com.petko.stocke.util.CalculateUtil" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<%
    long humanId = ParamUtil.getLong(renderRequest, WebKeys.Delivery.Request.ID);
    long storekeeperId = ParamUtil.getLong(renderRequest, WebKeys.Delivery.Request.STOREKEEPER_ID);
    Optional<Organization> organization = SessionUtil.getSessionOrgId(request); // Получение текущей организации из сессии
    long orgId = organization.get().getOrganizationId();

    User currentUser = PortalUtil.getUser(request); // Сотрудник склада в данной системе

    HumanDto humanEntity = HumanApplicationService.getHuman(humanId).get(); // Сущность заявителя
    BigDecimal limit = CalculateUtil.getLimitDecimal(humanEntity);
    BigDecimal remainder = CalculateUtil.getRemainderDecimal(humanEntity);

%>
<div>
    <p><b>Сотрудник: </b> <%=currentUser.getLastName()%> <%=currentUser.getFirstName()%> <%=currentUser.getMiddleName()%></br>
    <b>Организация: </b> <%= String.valueOf(organization.get().getName()) %></p>
</div>

<liferay-portlet:actionURL name="produceProduct" var="produceProductURL" >
    <liferay-portlet:param name="<%= WebKeys.Delivery.Request.ID %>" value="<%= String.valueOf(humanId) %>"/>
    <liferay-portlet:param name="<%= WebKeys.Delivery.Request.STOREKEEPER_ID %>" value="<%= String.valueOf(storekeeperId) %>"/>
    <liferay-portlet:param name="<%= WebKeys.Delivery.Request.ORG_ID %>" value="<%= String.valueOf(orgId) %>"/>
    <liferay-portlet:param name="<%= WebKeys.Delivery.Request.USER_ID %>" value="<%= String.valueOf(currentUser.getUserId()) %>"/>
</liferay-portlet:actionURL>

<aui:form id="produceActionForm" name="produceActionForm" action="<%= produceProductURL %>" enctype="multipart/form-data" method="post">
    <liferay-ui:panel-container accordion="true" markupView="lexicon">
        <liferay-ui:panel title="" persistState="true" cssClass="labelFluid">
            <clay:container-fluid>
                <clay:row>
                    <clay:col size="12">
                        <aui:input name="<%= WebKeys.Personal.Request.LIMIT %>"
                                   label="Выделенный лимит продукции"
                                   value="<%= String.valueOf(limit) %>" readonly="true"/>
                    </clay:col>
                </clay:row>
                <clay:row>
                    <clay:col size="12">
                        <aui:input name="<%= WebKeys.Delivery.Request.REMAINING_LIMIT %>"
                                   label="Остаток продукции"
                                   value="<%= String.valueOf(remainder) %>" readonly="true"/>
                    </clay:col>
                </clay:row>
            </clay:container-fluid>
            <clay:container-fluid>
                <clay:row>
                    <clay:col size="12">
                        <aui:input id="<%= WebKeys.Delivery.Request.ADD_LIMIT %>" name="<%= WebKeys.Delivery.Request.ADD_LIMIT %>" label="Количество выдачи продукции"
                                   cssClass="SnilsVar">
                            <aui:validator name="required" /> <%--//обязательность заполнености поля--%>
                            <aui:validator name="min">0.001</aui:validator> <%--//минимальное значение должно быть больше 0--%>
                        </aui:input>
                    </clay:col>
                </clay:row>
            </clay:container-fluid>
        </liferay-ui:panel>
    </liferay-ui:panel-container>
</aui:form>
