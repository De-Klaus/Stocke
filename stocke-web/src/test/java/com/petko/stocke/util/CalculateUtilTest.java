package com.petko.stocke.util;

import com.petko.stocke.dto.HumanDto;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.service.DeliveryApplicationService;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateUtilTest {

    private final HumanDto humanEntity = new HumanDto(1,"Petrov","Ivan",
            "Ivanovich","11.12.2012","9223372036854775807",
            "Berlin","Berlin","5","5",25.00,
            1.1,5,15);

    private CaseApplication caseApplication;
    private DeliveryApplicationService deliveryApplication;
    private CalculateUtil calculateUtil;

    @BeforeEach
    void prepare() throws ParseException {
        System.out.println("Before each: " + this);
        // создаём мок объект от класса UserDao который по умолчанию возвращает null, false на каждый метод
        this.caseApplication        =   Mockito.mock(CaseApplication.class);
        this.deliveryApplication    =   Mockito.mock(DeliveryApplicationService.class);
    }



    @Test
    void countBalanceProduct() {
        double addLimit = 12.10;
        JSONObject dataForm = new JSONObject("{balance:12.02}");
        var actualResult = CalculateUtil.countBalanceProduct(addLimit,dataForm);

        var expectedResult = BigDecimal.valueOf(24.12);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void shouldThrowExceptionIfJsonInvalid(){
        double addLimit = 12.10;
        JSONObject dataForm = new JSONObject("{}");
        var actualResult = CalculateUtil.countBalanceProduct(addLimit,dataForm);

        var expectedResult = BigDecimal.valueOf(12.10);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void countProduceProduct() {
        double subtractLimit = 12.10;
        JSONObject dataForm = new JSONObject("{remainder:24.20}");
        var actualResult = CalculateUtil.countProduceProduct(subtractLimit,dataForm);

        var expectedResult = BigDecimal.valueOf(12.1).setScale(3,RoundingMode.HALF_UP);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getLimitDecimal() {

        var actualResult = CalculateUtil.getLimitDecimal(humanEntity);

        var expectedResult = BigDecimal.valueOf(27.5).setScale(3,RoundingMode.HALF_UP);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getRemainderDecimal() {
        var actualResult = CalculateUtil.getRemainderDecimal(humanEntity);

        var expectedResult = BigDecimal.valueOf(15).setScale(3,RoundingMode.HALF_UP);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void getAmount() throws ParseException {

        Map<String, Object> filters = Map.of("filter_date_start","26.11.2020",
                "filter_date_end","28.11.2020",
                "filter_storage",new String[]{"product"});

        String date = "2020-11-28 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Mockito.doReturn(format.parse(date)).when(caseApplication).getStartDate();
        Mockito.doReturn("{\"storage_name\":\"product\",\"request\":\"12.5\"}").when(caseApplication).getAdditionalFields();
        Mockito.doReturn(List.of(caseApplication)).when(deliveryApplication).getDeliveryApplications();

        calculateUtil = new CalculateUtil(deliveryApplication);

        var actualResult = calculateUtil.getAmount(filters);

        var expectedResult = "12,500";

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}