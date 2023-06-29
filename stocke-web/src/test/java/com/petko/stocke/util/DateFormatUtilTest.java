package com.petko.stocke.util;

import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DateFormatUtilTest {

    @Test
    void getFormDate() throws ParseException {
        String strFormat = "dd.MM.yyyy";
        String date = "2020-11-28 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dataIn = format.parse(date);

        var actual = DateFormatUtil.getFormDate(dataIn,strFormat);

        var expected = "28.11.2020";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void parseDate() {
        String strFormat = "dd.MM.yyyy";
        String date = "2023-06-27T13:54:19+07";

        var actual = DateFormatUtil.parseDate(date,strFormat);

        var expected = "27.06.2023";

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testParseDate() throws ParseException {
        String date = "2023-06-27 00:00:00";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String strDate = "27.06.2023";

        var actual = DateFormatUtil.parseDate(strDate).get();

        var expected = format.parse(date);

        assertThat(actual).isEqualTo(expected);
    }
}