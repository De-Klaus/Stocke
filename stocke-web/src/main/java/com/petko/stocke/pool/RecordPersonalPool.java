package com.petko.stocke.pool;

import com.liferay.portal.kernel.exception.PortalException;
import com.petko.stocke.constants.Keys.API;
import com.petko.stocke.constants.UrlKeys;
import com.petko.stocke.constants.WebKeys;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.service.CaseApplicationLocalServiceUtil;
import com.petko.stocke.util.DateFormatUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class RecordPersonalPool {

    private final Long humanId;

    public RecordPersonalPool(Long humanId) {
        this.humanId = humanId;
    }


    /**
     * Forming parameters for creating a file
     * @return
     */
    public Map<String,String> getCreateParams(){
        Map<String, String> pdfParams = new HashMap<>();
        JSONObject jsonPer = getJsonPerson();
        String address = jsonPer.has("address") ? (String) jsonPer.get("address") : "";
        String fullName = jsonPer.has("fullName") ? (String) jsonPer.get("fullName") : "";
        String birthdate = jsonPer.has("birthdate") ? (String) jsonPer.get("birthdate") : "";
        String textField14 = jsonPer.has("textField14") ? (String) jsonPer.get("textField14") : "";
        String textField13 = jsonPer.has("textField13") ? (String) jsonPer.get("textField13") : "";
        String data11 = jsonPer.has("data11") ? (String) jsonPer.get("data11") : "";
        String textField = (jsonPer.has("textField11")&&jsonPer.has("textField12")) ? ((String) jsonPer.get("textField11"))+((String) jsonPer.get("textField11")) : "";

        String birthDate = DateFormatUtil.parseDate(birthdate, "dd.MM.yyyy");

        pdfParams.put("namePdf",     WebKeys.Delivery.FILE_NAME           );
        pdfParams.put("inputQr",     UrlKeys.URL_DELIVERY+humanId);
        pdfParams.put("address",     address             );
        pdfParams.put("fullName",    fullName            );
        pdfParams.put("birthdate",   birthDate           );
        pdfParams.put("textField14", textField14         );
        pdfParams.put("textField13", textField13         );
        pdfParams.put("data11",      data11              );
        pdfParams.put("textField",   textField           );

        return pdfParams;
    }

    /**
     * Get Parameters
     * @return
     */
    public Map<String,String> getSaveFileParams(){
        Map<String, String> pdfParams = new HashMap<>();
        JSONObject jsonObjectPerson = getJsonPerson();
        pdfParams.put("applicationId",String.valueOf(humanId));
        String repositoryId = jsonObjectPerson.has(API.PARAMS_HANDLER_REPOSITORY_ID)?
                String.valueOf(jsonObjectPerson.get(API.PARAMS_HANDLER_REPOSITORY_ID)):"41918";
        pdfParams.put("repositoryId",repositoryId);
        pdfParams.put("namePdf", WebKeys.Delivery.FILE_NAME);

        return pdfParams;
    }

    /**
     * Get app person
     * @return
     */
    private JSONObject getJsonPerson(){
        JSONObject jsonObjectPerson = new JSONObject();
        if(humanId!=null&&humanId!=0L){
            try {
                CaseApplication application = CaseApplicationLocalServiceUtil.getCaseApplication(humanId);
                jsonObjectPerson = new JSONObject(application.getAdditionalFields());
            } catch (PortalException e) {
                e.printStackTrace();
            }
        }
        return jsonObjectPerson;
    }


}
