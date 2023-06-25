<%@ page import="com.petko.stocke.constants.WebKeys" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/META-INF/resources/jsp/init.jsp" %>

<%Log log = LogFactoryUtil.getLog("/META-INF/resources/jsp/delivery/produce.jsp");%>

<%
   long number_aprove = ParamUtil.getLong(renderRequest, WebKeys.Delivery.APROVE); //номер заявления на вадачу продукции
   log.info("param aprove "+number_aprove);
%>

<div style="text-align: center">
   <img src="/o/stocke-web/img/success.png" style="width:50%;height:50%">
</div>
<h2 style="text-align: center;margin-top:20px;">Продукция выдана!</h2>
<p style="text-align: center;margin-top:20px;">Заявления на выдачу продукции №<%= number_aprove %></p>
