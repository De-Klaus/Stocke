package com.petko.stocke.util;

import com.petko.stocke.constants.Keys;
import com.petko.stocke.model.CaseApplication;
import org.json.JSONObject;

import java.math.BigDecimal;

public class JsonFieldUtil {

    /**
     * Retrieving All Output Values
     * @param application
     * @return
     */
    public static BigDecimal getValues(CaseApplication application) {
        JSONObject dataForm = new JSONObject(application.getAdditionalFields());
        if (dataForm.has(Keys.API.REQUEST))
            return BigDecimal.valueOf(dataForm.getDouble(Keys.API.REQUEST));
        if (dataForm.has(Keys.API.PURCHASE_DESIRED))
            return BigDecimal.valueOf(dataForm.getDouble(Keys.API.PURCHASE_DESIRED));
        return BigDecimal.ZERO;
    }
}
