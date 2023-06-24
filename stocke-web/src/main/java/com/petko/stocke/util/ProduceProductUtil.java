package com.petko.stocke.util;

import com.petko.stocke.constants.Keys;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.service.ApplicationService;
import com.petko.stocke.service.CaseApplicationLocalServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
public class ProduceProductUtil {


    /**
     * Change in the remaining volume of products in stock after issuance
     * @param orgId id организации
     * @param itemId id марки угля
     * @return
     */
    public static void prodeceProductGrades(Long orgId, Long itemId, BigDecimal issuedCoal){
        Optional<CaseApplication> applOpt = ApplicationService.getApplicationByIfLf(orgId);
        log.info("applOpt: "+applOpt.isEmpty());
        if(!applOpt.isEmpty()&&applOpt.get().getCaseModelId()== Keys.CP.CP_STORE){
            log.info("CP: "+applOpt.get().getCaseModelId());
            CaseApplication application = applOpt.get();
            String updateData = updateGradeStore(application.getAdditionalFields(),itemId,issuedCoal);
            application.setAdditionalFields(updateData);
            application.persist();
            // Update of application data
            CaseApplicationLocalServiceUtil.updateCaseApplication(application);
        }
    }

    /**
     * Updating the amount of coal data for a given grade
     * @param jsonString
     * @param itemId
     */
    private static String updateGradeStore(String jsonString, Long itemId, BigDecimal issuedCoal){
        JSONObject dataForm = new JSONObject(jsonString);
        if(dataForm.has(Keys.API.DATA_GRID_2)) {
            JSONArray coalGrades = dataForm.getJSONArray(Keys.API.DATA_GRID_2);
            if(coalGrades.length()>0) {
                for (int i = 0; i < coalGrades.length(); i++) {
                    JSONObject gradeAll = coalGrades.getJSONObject(i);
                    if(gradeAll.has(Keys.API.COAL_COUNT)&&gradeAll.has(Keys.API.COAL_GRADE)){
                        JSONObject grade = gradeAll.getJSONObject(Keys.API.COAL_GRADE);
                        if(grade.getLong(Keys.API.VALUE)==itemId){
                            BigDecimal coalCount = BigDecimal.valueOf(gradeAll.getDouble(Keys.API.COAL_COUNT));
                            System.out.println(coalCount);
                            System.out.println(issuedCoal);
                            BigDecimal remainderNew = coalCount.subtract(issuedCoal); //вычитание разницы между числами для большей точно делаем в классе BigDecimal
                            System.out.println(remainderNew);
                            gradeAll.put(Keys.API.COAL_COUNT,remainderNew);

                        }
                    }
                }
            }
        }
        return dataForm.toString();
    }
}
