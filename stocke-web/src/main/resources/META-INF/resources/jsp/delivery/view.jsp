<%@ page import="com.liferay.portal.kernel.model.Organization" %>
<%@ page import="com.liferay.portal.kernel.model.User" %>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@ page import="com.petko.stocke.constants.WebKeys" %>
<%@ page import="com.petko.stocke.dto.HumanDto" %>
<%@ page import="com.petko.stocke.service.HumanApplicationService" %>
<%@ page import="com.petko.stocke.util.CalculateUtil" %>
<%@ page import="com.petko.stocke.util.DateFormatUtil" %>
<%@ page import="com.petko.stocke.util.SessionUtil" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/META-INF/resources/jsp/init.jsp" %>

<%
    long humanId=0;
    HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
    String humanIdReq = httpReq.getParameter("humanId");                                    //получение humanId через сканирование QR кода

    long humanIdAction = ParamUtil.getLong(renderRequest, WebKeys.Delivery.HUMAN_ID); //получение humanId через заполнения формы поиска

    if(humanIdReq!=null)
        humanId = Long.parseLong(humanIdReq);
    if(humanIdAction!=0)
        humanId = humanIdAction;

    Optional<Organization> organization = SessionUtil.getSessionOrgId(request); // Получение текущей организации из сессии
    User currentUser = PortalUtil.getUser(request); // Сотрудник склада в данной системе
    Optional<HumanDto> humanEntityOpt = HumanApplicationService.getHuman(humanId); // Сущность с параметрами заявителя

%>

<% if(!humanEntityOpt.isEmpty()&&currentUser!=null){
    HumanDto humanEntity = humanEntityOpt.get();
    String birthdate = DateFormatUtil.parseDate(humanEntity.getBirthdate(),"dd-MM-yyyy");
    BigDecimal limit = CalculateUtil.getLimitDecimal(humanEntity);
    BigDecimal remainder = CalculateUtil.getRemainderDecimal(humanEntity);
%>

<portlet:renderURL var="produceURL">
    <portlet:param name="mvcPath" value="/jsp/delivery/produce.jsp"/>
    <portlet:param name="<%= WebKeys.Delivery.Request.ID %>" value="<%= String.valueOf(humanId) %>"/>
    <portlet:param name="<%= WebKeys.Delivery.Request.STOREKEEPER_ID %>" value="<%= String.valueOf(currentUser.getUserId()) %>"/>
</portlet:renderURL>
<p><b>Сотрудник: </b> <%=currentUser.getLastName()%> <%=currentUser.getFirstName()%> <%=currentUser.getMiddleName()%></p>
    <% if(!organization.isEmpty()){%>
<p><b>Организация: </b> <%= String.valueOf(organization.get().getName()) %></p>
<aui:form name="viewForm" action="" >
            <liferay-ui:panel-container accordion="true" markupView="lexicon">
            <liferay-ui:panel title="Данные физического лица" persistState="false" cssClass="labelFluid">
                <aui:input name="<%= WebKeys.Personal.Request.LASTNAME %>" label="Фамилия"
                           value="<%= String.valueOf(humanEntity.getLastname()) %>" readonly="true"/>

                <aui:input name="<%= WebKeys.Personal.Request.FIRSTNAME %>" label="Имя"
                           value="<%= String.valueOf(humanEntity.getFirstname()) %>" readonly="true"/>

                <aui:input name="<%= WebKeys.Personal.Request.MIDDLENAME %>" label="Отчество"
                           value="<%= String.valueOf(humanEntity.getMiddlename()) %>" readonly="true"/>

                <aui:input name="<%= WebKeys.Personal.Request.BIRTHDATE %>" label="Дата рождения"
                           value="<%= String.valueOf(birthdate) %>" readonly="true"/>
            </liferay-ui:panel>
                <clay:row style="margin-top:20px;">
                        <clay:col size="12">
                            <aui:input name="<%= WebKeys.Personal.Request.LIMIT %>"
                            label="Выделенный лимит продукции"
                            value="<%=String.valueOf(limit) %>" readonly="true"/>
                        </clay:col>
                    </clay:row>
                <clay:row >
                        <clay:col size="12">
                            <aui:input name="<%= WebKeys.Personal.Request.REMAINDER %>"
                            label="Остаток продукции"
                            value="<%= String.valueOf(remainder) %>" readonly="true"/>
                        </clay:col>
                    </clay:row>
        </liferay-ui:panel-container>
            <div style="text-align: center">
                <aui:button style="text-align: center;" name="produce" value="Продолжить" type="submit" cssClass="btn btn-primary filterButton" href="${produceURL.toString()}" />
            </div>
        </aui:form>
    <%}
    else {%>
        <h3 style="text-align: center;color: red;">Нужно выбрать организацию для выдачи продукции!</h3>
        <%}%>
<% } else { %>

<portlet:renderURL var="searchBySnilsURL">
    <portlet:param name="idSearch" value="0"/>
    <portlet:param name="mvcPath" value="/jsp/delivery/search.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="searchByFIOURL">
    <portlet:param name="idSearch" value="1"/>
    <portlet:param name="mvcPath" value="/jsp/delivery/search.jsp"/>
</portlet:renderURL>

<div style="text-align: center">
    <aui:button style="text-align: center;margin-top:30px;" name="produce" value="Поиск заявителя по СНИЛС" type="submit" cssClass="btn btn-primary filterButton" href="${searchBySnilsURL.toString()}" />
    <aui:button style="text-align: center;margin-top:30px;" name="produce" value="Поиск заявителя по ФИО" type="submit" cssClass="btn btn-primary filterButton" href="${searchByFIOURL.toString()}" />
</div>
    <h3 style="text-align: center;color: red;">К сожалению указанная ссылка не действительна или пользователь не найден!</h3>
    <h3 style="text-align: center;color: #000000;">Обновите ваш QR-код</h3>
    <h3 style="text-align: center;color: black;">или</h3>
    <h3 style="text-align: center;color: black;">перейдите к поиску заявителя по его СНИЛС и ФИО.</h3>
<% } %>