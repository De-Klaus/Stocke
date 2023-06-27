package com.petko.stocke.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

/**
 * <p>Содержит форматы для вывода/парсинга дат</p>
 *
 * @author Petko
 */
@Slf4j
public class DateFormatUtil {

    /**
     *  Return the date in the given format
     *
     *  @param date
     *  @param format
     */
    public static String getFormDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * Return the date in the given format
     *
     *  @param dateIn
     *  @param format
     */
    public static String parseDate(String dateIn, String format) {
        if(dateIn.contains("T"))
            dateIn = dateIn.substring(0,dateIn.indexOf("T"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateIn, formatter);
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        String outDate= getFormDate(date,format);
        return outDate;
    }


    /**
     * Return the date in the given format
     * @param stringDate
     * @return
     */
    public static Optional<Date> parseDate(String stringDate) {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return Optional.ofNullable(format.parse(stringDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

}
