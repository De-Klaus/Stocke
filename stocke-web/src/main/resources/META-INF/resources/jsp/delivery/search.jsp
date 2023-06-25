<%@page import="com.petko.stocke.constants.WebKeys" %>
<%@page import="javax.portlet.PortletRequest" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@include file="/META-INF/resources/jsp/init.jsp" %>

<%Log log = LogFactoryUtil.getLog("/META-INF/resources/jsp/delivery/search.jsp");%>

<% long idSearch = ParamUtil.getLong(renderRequest, WebKeys.Delivery.SEARCH_ID);
%>

<liferay-portlet:actionURL name="serchRecords" var="serchRecordsURL" >
</liferay-portlet:actionURL>

<aui:form id="serchActionForm" name="serchActionForm" action="<%= serchRecordsURL %>" enctype="multipart/form-data" method="post">
   <liferay-ui:panel-container accordion="true" markupView="lexicon">
      <liferay-ui:panel title="Заполните поля поиска" persistState="false" cssClass="labelFluid">
         <liferay-ui:error message="service.error.snils" key="snils"/>
         <% if(idSearch==0){%>
         <aui:input type="number" name="<%= WebKeys.Delivery.Request.SNILS_S %>" label="СНИЛС">
            <aui:validator name="minLength">11</aui:validator>
            <aui:validator name="maxLength">11</aui:validator>
            <aui:validator name="required"/>
         </aui:input>
         <% } else if(idSearch==1){%>
         <liferay-ui:error message="service.error.lastname" key="lastname"/>
         <aui:input type="text" name="<%= WebKeys.Delivery.Request.LASTNAME_S %>" label="Фамилия">
            <aui:validator name="required" />
         </aui:input>
         <liferay-ui:error message="service.error.firstname" key="firstname"/>
         <aui:input type="text" name="<%= WebKeys.Delivery.Request.FIRSTNAME_S %>" label="Имя">
            <aui:validator name="required" />
         </aui:input>
         <liferay-ui:error message="service.error.middlename" key="middlename"/>
         <aui:input type="text" name="<%= WebKeys.Delivery.Request.MIDDLENAME_S %>" label="Отчество">
            <aui:validator name="required" />
         </aui:input>
         <liferay-ui:error message="service.error.birthdate" key="birthdate"/>
         <aui:input type="date" name="<%= WebKeys.Delivery.Request.BIRTHDATE_S %>" label="Дата рождения">
            <aui:validator name="required" />
            <aui:validator name="custom"  errorMessage="Дата не может быть больше сегодняшнего дня">
                       function (val, fieldNode, ruleValue) {
                          var val = new Date(Date.parse(val,"dd MM yyyy"));
                          var adult=new Date();
                          adult.setFullYear(adult.getFullYear())
                          return (val < adult);
                       }
            </aui:validator>
         </aui:input>
         <% }%>
      </liferay-ui:panel>
   </liferay-ui:panel-container>
   <div style="text-align: center;margin-top:15px;">
         <aui:button name="executed" value="Найти" type="submit" cssClass="btn btn-primary filterButton" />
   </div>
</aui:form>
