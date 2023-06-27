package com.petko.stocke.util;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DataUtilTest {

    @Test
    void addEndDayTime() throws ParseException {
        String date = "2020-11-28 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dataIn = format.parse(date);

        Date actualResult = DateUtil.addEndDayTime(dataIn);

        String dateExp = "2020-11-29 00:00:00";
        Date expectedDate = format.parse(dateExp);

        assertThat(actualResult).isEqualTo(expectedDate);
    }

    @Test
    void calculateDateRangeTrue() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart = format.parse("2023-01-28 00:00:00");
        Date dateEnd = format.parse("2023-11-28 00:00:00");
        Date date = format.parse("2023-05-28 00:00:00");

        boolean actualResult = DateUtil.calculateDateRange(dateStart,dateEnd,date);

        assertEquals(actualResult,true);
    }

    @Test
    void calculateDateRangeFalse() throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateStart = format.parse("2023-01-28 00:00:00");
        Date dateEnd = format.parse("2023-11-28 00:00:00");
        Date date = format.parse("2023-12-28 00:00:00");

        boolean actualResult = DateUtil.calculateDateRange(dateStart,dateEnd,date);

        assertEquals(actualResult,false);
    }

    @Test
    void getSplitDate() {
        String date = "2023-06-27T13:54:19+07";

        String actualResult = DateUtil.getSplitDate(date).get();

        assertThat(actualResult).isEqualTo("2023-06-27");
    }
}