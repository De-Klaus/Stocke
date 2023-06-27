package com.petko.stocke.util;

import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.petko.stocke.constants.Keys;
import com.petko.stocke.model.CaseApplication;
import org.json.JSONObject;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class FilterUtil {

    /**
     * Filter requests by date
     * @param date_start
     * @param date_end
     * @param application
     * @return
     */
    public static boolean filterDateRange(String date_start, String date_end, CaseApplication application) {
        boolean startIsNotBlank = Validator.isBlank(date_start);
        boolean endIsNotBlank = Validator.isBlank(date_end);

        if(!startIsNotBlank&&!endIsNotBlank){
            Optional<Date> startOpt = DateFormatUtil.parseDate(date_start);
            Optional<Date> endOpt   = DateFormatUtil.parseDate(date_end);
            if(startOpt.isPresent() && endOpt.isPresent()){
                return DateUtil.calculateDateRange(startOpt.get(),
                        endOpt.get(),
                        application.getStartDate());
            }
        }
        return true;
    }

    /**
     * Filter requests by org name
     * @param storages
     * @param application
     * @return
     */
    public static boolean filterOrgName(List<String> storages, CaseApplication application) {
        if (storages.size() > 0) {
            String dataJSON = application.getAdditionalFields();
            JSONObject dataForm = new JSONObject(dataJSON);
            AtomicBoolean result = new AtomicBoolean(false);
            storages.forEach(storage ->{
                if (dataForm.has(Keys.API.STORAGE_NAME)) {
                    String storage_name = dataForm.optString(Keys.API.STORAGE_NAME);
                    if(!Validator.isBlank(storage_name)&&storage.equals(storage_name))
                        result.set(true);
                }
                if(dataForm.has(Keys.API.ORG)) {
                    String storage_name = dataForm.optString(Keys.API.ORG);
                    if (!Validator.isBlank(storage_name) && storage.equals(storage_name))
                        result.set(true);
                }
            });
            return result.get();
        }
        return false;
    }
}
