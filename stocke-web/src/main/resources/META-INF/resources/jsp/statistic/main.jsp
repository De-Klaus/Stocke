<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.petko.stocke.util.StatisticUtil" %>
<%@ page import="javax.portlet.PortletMode" %>
<%@ page import="javax.portlet.MutableRenderParameters" %>
<%@ page import="com.petko.stocke.dto.OrgPurchaseDto" %>
<%@ page import="com.petko.stocke.util.CalculateUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/META-INF/resources/jsp/init.jsp" %>

<%Log log = LogFactoryUtil.getLog("/META-INF/resources/jsp/personal/view.jsp");%>

<%
    List<OrgPurchaseDto> storages = StatisticUtil.getAllStorageNames();
    Map<String, Object> filters = new HashMap<String, Object>();
    PortletURL iteratorURL = liferayPortletResponse.createLiferayPortletURL(
		themeDisplay.getPlid(), portletDisplay.getId(), PortletRequest.RENDER_PHASE, false);

    String[] filterStorage = ParamUtil.getStringValues(request, "filter_storage");
%>

<H2>Статистика по выданной продукции</H2>

<div>
<aui:form name="filterForm" method="post" action="<%= iteratorURL %>" cssClass="filter_form_fill">

<aui:fieldset label="Период выдачи продукции ">
    <aui:row>

            <%
                Calendar endDate = Calendar.getInstance();
                endDate.setTime(new Date());

                Calendar startDate = Calendar.getInstance();
                startDate.set(endDate.get(Calendar.YEAR),1,1);
            %>

        <aui:col span="2">
                <b>Дата начала периода (включительно)</b>
                <liferay-ui:input-date name="filter_date_start"
                dayValue="<%= startDate.get(Calendar.DAY_OF_MONTH) %>"
                monthValue="<%= startDate.get(Calendar.MONTH) %>"
                yearValue="<%= startDate.get(Calendar.YEAR) %>" />
        </aui:col>

        <aui:col span="2">
                <b>Дата окончания периода (включительно)</b>
                <liferay-ui:input-date name="filter_date_end"
                        dayValue="<%= endDate.get(Calendar.DAY_OF_MONTH)%>"
                        monthValue="<%= endDate.get(Calendar.MONTH) %>"
                        yearValue="<%= endDate.get(Calendar.YEAR) %>" />
        </aui:col>

	</aui:row>
</aui:fieldset>
	<aui:row>
        <aui:col span="4">
            <b>Наименование склада</b>
            <script>
                $(function() {
                    $('.selectpicker').selectpicker();
                });
            </script>

            <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
            <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta2/dist/css/bootstrap-select.min.css">
            <script src="https://cdn.jsdelivr.net/npm/bootstrap-select@1.14.0-beta2/dist/js/bootstrap-select.min.js"/>

            <select class="form-control selectpicker"
                    multiple data-live-search="true"
                    id="<portlet:namespace/>filter_storage"
                    name="<portlet:namespace/>filter_storage"
                    data-live-search="true"
                    aria-label="Default select example"
                    onChange="ajaxCall();"
                    title="..."
                    inlineField="true"
                    showEmptyOption="true"
                    cssClass="input-xxlarge"
                    data-actions-box="true" <%--выделение или не выделение всех сразу--%>
            >
                    <%
                        // добаление выбранных компонентов селекта после применения фильтра
                        List<OrgPurchaseDto> mapSelect = StatisticUtil.getShowSelected(storages, filterStorage);
                        for (OrgPurchaseDto op : mapSelect) { %>
                        <aui:option value="<%= op.getOrgId() %>"
                                    selected="<%=op.isShow()%>"
                                    label="<%=op.getOrgName()%>" />
                    <%
                        } %>
            </select>
        </aui:col>
	</aui:row>
    <br/>
    <aui:row>
        <aui:col span="4">
            <div style="padding-bottom: 10px">
                <a cssClass="btn btn-primary" class="btn btn-primary" href="javascript:;" onClick="javascript:submit()">
                    <i class="fas fa-search" style="margin-left: 80px; margin-right: 20px;"></i>
                    <liferay-ui:message key="Применить фильтр"/>
                    <i style="margin-right: 200px;"></i>
                </a>
            </div>
        </aui:col>
    </aui:row>
</aui:form>

    <script type="text/javascript">
        function submit() {
            var form = document.forms["<portlet:namespace/>filterForm"];
            form.action = "<%= iteratorURL %>";
            form.submit();
        }
    </script>

</div>

<%
    filters.put("filter_storage", ParamUtil.getStringValues(request, "filter_storage"));
    filters.put("filter_date_start", ParamUtil.getString(request, "filter_date_start", ""));
    filters.put("filter_date_end", ParamUtil.getString(request, "filter_date_end", ""));

    log.info("Filters: "+ Arrays.toString(ParamUtil.getStringValues(request, "filter_storage")));

    iteratorURL.setParameter("filter_storage", ParamUtil.getStringValues(request, "filter_storage"));
    iteratorURL.setParameter("filter_date_start", ParamUtil.getString(request, "filter_date_start", ""));
    iteratorURL.setParameter("filter_date_end", ParamUtil.getString(request, "filter_date_end", ""));
%>
<div></div>


Выдано <%= CalculateUtil.getAmount(filters) %> тонн