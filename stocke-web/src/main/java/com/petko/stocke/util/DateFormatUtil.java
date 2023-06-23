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
 * @author PetkoN
 */
@Slf4j
public class DateFormatUtil {

    /**
     * @return дату в заданном формате
     *
     *  @param date   - Дата
     *  @param format   - Формат
     */
    public static String getFormDate(Date date, String format) {
        DateFormat df = new SimpleDateFormat(format);
        return df.format(date);
    }

    /**
     * @return String дату в заданном формате
     *
     *  @param dateIn   - Строка даты
     *  @param format   - Формат
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
     * @return Date включающую время даты 23:59:59
     *
     *  @param inDate   - дата
     */
    public static Date setTimeEnd(Date inDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(inDate);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        cal.set(Calendar.MILLISECOND,59);
        Date newTimeDate = cal.getTime();
        return newTimeDate;
    }


    /**
     * Распарсить дату из строки в указанный формат
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

    /**
     * @return формат "дд.мм.гггг"
     */
    public static DateFormat dmy() {
        return new SimpleDateFormat("dd.MM.yyyy");
    }

    /**
     * @return формат "гггг-мм-дд"
     */
    public static DateFormat ymd() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    /**
     * @return формат "гггг" (только год)
     */
    public static DateFormat yyyy() {
        return new SimpleDateFormat("yyyy");
    }

    /**
     * @return формат "гггг-мм-дд чч:мм:сс" (только год)
     */
    public static DateFormat ymdT() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    }
}
