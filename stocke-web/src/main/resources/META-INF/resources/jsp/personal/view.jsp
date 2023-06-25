<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ page import="com.petko.stocke.constants.WebKeys" %>
<%@ page import="com.petko.stocke.dto.HumanDto" %>
<%@ page import="com.petko.stocke.service.HumanApplicationService" %>
<%@ page import="com.petko.stocke.util.CalculateUtil" %>
<%@ page import="static com.petko.stocke.constants.UrlKeys.URL_DELIVERY" %>
<%@ page import="com.petko.stocke.util.DateFormatUtil" %>
<%@ page import="com.petko.stocke.util.QrCodeUtil" %>
<%@ page import="java.math.BigDecimal" %>
<%@ page import="com.petko.stocke.util.StringUtil" %>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/META-INF/resources/jsp/init.jsp" %>

<%
	User currentUser = PortalUtil.getUser(request);
	String snils = currentUser.getExpandoBridge().getAttribute("user-snils").toString();
	long humanId = HumanApplicationService.findIdBySnils(snils);

	String lastName = currentUser.getLastName();
	String firstName = currentUser.getFirstName();
	String middleName = currentUser.getMiddleName();
	long contId = currentUser.getContactId();
	long userId = currentUser.getUserId();

	String birthDate = DateFormatUtil.getFormDate(currentUser.getBirthday(), "yyyy-MM-dd");

	if (humanId==0)
		humanId = HumanApplicationService.findByFioAndBirthDay(lastName, firstName, middleName, birthDate);

	Optional<HumanDto> humanEntity = HumanApplicationService.getHuman(humanId);
%>

<% if(humanEntity.isPresent()){

	HumanDto entry = HumanApplicationService.getHuman(humanId).get(); // Сущность заявителя

	if (!entry.getSnils().equals(snils)){
		entry.setSnils(StringUtil.removeSpaces(snils));
		HumanApplicationService.updateHuman(entry,contId, userId);
	}
	BigDecimal limitBD = CalculateUtil.getLimitDecimal(entry);
	BigDecimal remainderBD = CalculateUtil.getRemainderDecimal(entry);
%>

<aui:form name="docActionForm" method="POST" action="">
	<liferay-ui:panel-container accordion="true" markupView="lexicon">
		<liferay-ui:panel title="Данные физического лица" persistState="false" cssClass="labelFluid">
			<aui:input name="<%= WebKeys.Personal.Request.LASTNAME %>" label="Фамилия"
                       value="<%= String.valueOf(entry.getLastname()) %>" readonly="true" />

			<aui:input name="<%= WebKeys.Personal.Request.FIRSTNAME %>" label="Имя"
                       value="<%= String.valueOf(entry.getFirstname()) %>" readonly="true"/>

			<aui:input name="<%= WebKeys.Personal.Request.MIDDLENAME %>" label="Отчество"
                       value="<%= String.valueOf(entry.getMiddlename()) %>" readonly="true" />

			<aui:input name="<%= WebKeys.Personal.Request.SNILS %>" label="СНИЛС"
                       value="<%= String.valueOf(entry.getSnils()) %>" readonly="true"/>
			<aui:input name="<%= WebKeys.Personal.Request.TOWN %>" label="Населённый пункт"
                       value="<%= String.valueOf(entry.getTown()) %>" readonly="true" />
			<aui:input name="<%= WebKeys.Personal.Request.STREET %>" label="Улица"
                       value="<%= String.valueOf(entry.getStreet()) %>" readonly="true"/>
			<clay:container-fluid>
				<clay:row>
					<clay:col size="6">
						<aui:input name="<%= WebKeys.Personal.Request.HOUSE %>" label="Номер дома"
                                   value="<%= String.valueOf(entry.getHouse()) %>" readonly="true"/>
					</clay:col>
					<clay:col size="6">
						<aui:input name="<%= WebKeys.Personal.Request.FLAT %>" label="Этажность"
                                   value="<%= String.valueOf(entry.getFlat()) %>" readonly="true"/>
					</clay:col>
				</clay:row>
				<clay:row>
					<clay:col size="12">
						<aui:input name="<%= WebKeys.Personal.Request.STOREYS %>" label="Номер квартиры"
                                   value="<%= String.valueOf(entry.getStoreys()) %>" readonly="true"/>
					</clay:col>
				</clay:row>
				<clay:row>
					<clay:col size="12">
						<aui:input name="<%= WebKeys.Personal.Request.SQUARE %>" label="Площадь квартиры"
                                   value="<%= String.valueOf(entry.getSquare()) %>" readonly="true"/>
					</clay:col>
				</clay:row>
			</clay:container-fluid>
		</liferay-ui:panel>
		<liferay-ui:panel title="Информация о лимитах продукции"  persistState="false" cssClass="labelFluid">
			<clay:container-fluid>
				<clay:row>
					<clay:col size="12">
						<aui:input name="<%= WebKeys.Personal.Request.LIMIT %>" label="Выделенный лимит продукции"
                                   value="<%= String.valueOf(limitBD) %>" readonly="true"/>
					</clay:col>
				</clay:row>
				<clay:row>
					<clay:col size="12">
						<aui:input name="<%= WebKeys.Personal.Request.REMAINDER %>" label="Остаток продукции"
                                   value="<%= String.valueOf(remainderBD) %>" readonly="true"/>
					</clay:col>
				</clay:row>
			</clay:container-fluid>
			<p style="text-align: center"><img src="<%=QrCodeUtil.toBase64QrCode(URL_DELIVERY+humanId)%>" /></p>
		</liferay-ui:panel>
	</liferay-ui:panel-container>
</aui:form>

<liferay-portlet:actionURL name="downloadPersonalQr" var="downloadPersonalQrURL" ></liferay-portlet:actionURL>
<aui:form id="downloadPersonalForm" name="downloadPersonalForm" action="<%= downloadPersonalQrURL %>" enctype="multipart/form-data" method="post">
	<aui:input type="hidden" name="humanId" value='<%= String.valueOf(humanId) %>' />
	<div style="text-align: center;">
		<aui:button name="executed" href='#'  value="Выгрузить карточку" onClick="downloadAction()" type="submit" cssClass="btn btn-primary filterButton"/>
	</div>
</aui:form>

<script type="text/javascript">
	function downloadAction() {
		console.log("Downloading...");
		var form = document.forms["<portlet:namespace/>downloadPersonalForm"];
		form.action = "<%= downloadPersonalQrURL %>";
		form.submit();
	}
</script>

<% } else { %>
<h3 style="text-align: center;">Пользователь: </h3>
<div style="text-align: center;">
	<aui:form style="text-align: center">
		<aui:input name="esialastname" label="Фамилия"
				   value="<%= String.valueOf(currentUser.getLastName()) %>" readonly="true" />

		<aui:input name="esiafirstname" label="Имя"
				   value="<%= String.valueOf(currentUser.getFirstName()) %>" readonly="true"/>

		<aui:input name="esiamiddlename" label="Отчество"
				   value="<%= String.valueOf(currentUser.getMiddleName()) %>" readonly="true" />
	</aui:form>
</div>
<h5 style="text-align: center;color: red;">Данный пользователь не был занесен в систему. Для получение доступа к системе необходимо обратиться в администрацию.</h5>
<% } %>


