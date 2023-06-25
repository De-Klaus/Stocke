package com.petko.stocke.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.petko.stocke.constants.Keys;
import com.petko.stocke.dto.HumanDto;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.service.DeliveryApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
public class CalculateUtil {

    /**
     * Summation of output
     * @param addLimit
     * @param dataForm
     * @return
     */
    public static BigDecimal countBalanceProduct(double addLimit, JSONObject dataForm) {
        BigDecimal remainder = BigDecimal.valueOf(dataForm.optDouble("balance"));
        BigDecimal requestRemainder = BigDecimal.valueOf(addLimit);
        BigDecimal balanceNew = remainder.add(requestRemainder);
        return balanceNew;
    }

    /**
     * Issuance calculation
     * @param addLimit
     * @param dataForm
     * @return
     */
    public static BigDecimal countProduceProduct(double addLimit, JSONObject dataForm) {
        BigDecimal remainder = BigDecimal.valueOf(dataForm.optDouble("remainder"));
        BigDecimal requestRemainder = BigDecimal.valueOf(addLimit);
        BigDecimal remainderNew = remainder.subtract(requestRemainder);
        remainderNew = remainderNew.setScale(3, RoundingMode.HALF_UP);
        return remainderNew;
    }

    /**
     * Calculation of the limit production and conversion to BigDecimal
     * @param humanEntity
     * @return
     */
    public static BigDecimal getLimitDecimal(HumanDto humanEntity){
        BigDecimal square = BigDecimal.valueOf(humanEntity.getSquare()!=0?humanEntity.getSquare():1);
        BigDecimal coefficient = BigDecimal.valueOf(humanEntity.getCoefficient()!=0?humanEntity.getCoefficient():1);
        // Calculation of the allocated limit production
        return square.multiply(coefficient).setScale(3, RoundingMode.HALF_UP);// Выделенный лимит продукции
    }

    /**
     * Obtaining the balance products and converting to BigDecimal
     * @param humanEntity
     * @return
     */
    public static BigDecimal getRemainderDecimal(HumanDto humanEntity){
        return new BigDecimal(humanEntity.getRemainder()).setScale(3, RoundingMode.HALF_UP);
    }

    /**
     * Summarizes the amount issued on applications
     *
     * @param filters
     * @return Amount of issued (in tons)
     */
    public static String getAmount(Map<String, Object> filters) {
        // filter data
        String date_start = GetterUtil.getString(filters.get("filter_date_start"), StringPool.BLANK);
        String date_end = GetterUtil.getString(filters.get("filter_date_end"), StringPool.BLANK);
        List<String> storages = Arrays.asList((String[]) filters.get("filter_storage"));

        // receiving all applications and filtering them by date and organizations
        Optional<BigDecimal> resultCount = DeliveryApplicationService.getDeliveryApplications()
                .stream()
                // filter by date
                .filter(application ->
                        FilterUtil.filterDateRange(date_start,date_end,application))
                // filter by organization
                .filter(application ->
                        FilterUtil.filterOrgName(storages,application))
                .map(application ->
                        getValues(application)
                )
                .reduce((a, b) -> a.add(b));
        log.debug("sum: "+resultCount);

        return resultCount.isPresent() ?
                String.format("%.3f", resultCount.get().doubleValue())
                : "0.0";
    }

    /**
     * Retrieving All Output Values
     * @param application
     * @return
     */
    private static BigDecimal getValues(CaseApplication application) {
        JSONObject dataForm = new JSONObject(application.getAdditionalFields());
        if (dataForm.has(Keys.API.REQUEST))
            return BigDecimal.valueOf(dataForm.getDouble(Keys.API.REQUEST));
        if (dataForm.has(Keys.API.PURCHASE_DESIRED))
            return BigDecimal.valueOf(dataForm.getDouble(Keys.API.PURCHASE_DESIRED));
        return BigDecimal.ZERO;
    }
}
