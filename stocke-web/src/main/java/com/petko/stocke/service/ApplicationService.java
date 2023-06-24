package com.petko.stocke.service;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.petko.stocke.constants.Keys;
import com.petko.stocke.constants.Keys.*;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.model.StatusModel;
import com.petko.stocke.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
public class ApplicationService {

    /**
     * Receiving applications for the specified modelId and statusName
     * @param modelId
     * @return
     */
    public static List<CaseApplication> getApplications(long modelId, String statusName) {
        DynamicQuery query = CaseApplicationLocalServiceUtil.dynamicQuery();
        query.add(RestrictionsFactoryUtil.eq(QUERY.CASE_MODEL_ID, modelId));
        query.add(RestrictionsFactoryUtil.eq(QUERY.ARCHIVE, false));
        String statusId = getStatusId(modelId,statusName)
                .orElseThrow(()->new IllegalStateException(String.format("Статус %s не найден", statusName)));
        log.debug("Status: " + statusId);
        query.add(RestrictionsFactoryUtil.eq(QUERY.STATUS, statusId));
        return CaseApplicationLocalServiceUtil.dynamicQuery(query);
    }

    /**
     * Receiving applications for the specified modelId
     * @param modelId
     * @return
     */
    public static List<CaseApplication> getApplications(long modelId) {
        DynamicQuery query = CaseApplicationLocalServiceUtil.dynamicQuery();
        query.add(RestrictionsFactoryUtil.eq(QUERY.CASE_MODEL_ID, modelId));
        query.add(RestrictionsFactoryUtil.eq(QUERY.ARCHIVE, false));
        return CaseApplicationLocalServiceUtil.dynamicQuery(query);
    }

    /**
     * Receiving applications for the specified modelIds
     * @param modelIds
     * @return
     */
    public static List<CaseApplication> getApplications(List<Long> modelIds) {
        DynamicQuery query = CaseApplicationLocalServiceUtil.dynamicQuery();
        query.add(PropertyFactoryUtil.forName(QUERY.CASE_MODEL_ID).in(modelIds));
        query.add(RestrictionsFactoryUtil.eq(QUERY.ARCHIVE, false));
        return CaseApplicationLocalServiceUtil.dynamicQuery(query);
    }

    public static Optional<CaseApplication> getApplicationByIfLf(Long organizationId) {
        return getApplications(List.of(
                Keys.CP.CP_MINE,
                Keys.CP.CP_STORE
        )).stream()
                .filter(application->{
                    JSONObject applData = new JSONObject(application.getAdditionalFields());
                    if(applData.has(Keys.API.ORG_ID_LF)){
                        Long orgIdLf = StringUtil.checkAndGetNumeric(applData.get(Keys.API.ORG_ID_LF));
                        if(orgIdLf.compareTo(organizationId)==0)
                            return true;
                    }
                    return false;
                }).findFirst();
    }

    /**
     * Получить id статуса по заданым параметрам
     * @param cpId
     * @param statusName
     * @return
     */
    public static Optional<String> getStatusId(long cpId, String statusName) {
        List<StatusModel> statusList = StatusModelLocalServiceUtil.getStatusModels(-1,-1).stream()
                .filter(statusModel -> statusModel.getCaseModelId()==cpId)
                .filter(statusModel->statusModel.getStatus().equals(statusName))
                .collect(Collectors.toList());
        Optional<StatusModel> status = statusList.stream().findFirst();
        if(status.isPresent()){
            String statusId = String.valueOf(status.get().getId());
            return Optional.of(statusId);
        }
        return Optional.empty();
    }
}
