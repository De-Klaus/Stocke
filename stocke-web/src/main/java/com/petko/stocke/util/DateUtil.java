package com.petko.stocke.util;


import lombok.extern.slf4j.Slf4j;

import java.util.*;

@Slf4j
public class DateUtil {
    /**
     * Add 24 hours so that the whole day of the specified date is inclusive
     * @param date
     * @return
     */
    public static Date addEndDayTime(Date date){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        return c.getTime();
    }

    /**
     * Checking the conditions for an application to fall into the tender range
     * @param start
     * @param end
     * @param appDate
     * @return
     */
    public static boolean calculateDateRange(Date start, Date end, Date appDate){
        Date endDate = addEndDayTime(end);

        long difAppStart = appDate.getTime() - start.getTime();
        long difAppEnd = endDate.getTime() - appDate.getTime();

        if (difAppStart >= 0 && difAppEnd >= 0)
            return true;

        return false;
    }

    /**
     * Getting the date before T
     * @param date
     * @return
     */
    public static Optional<String> getSplitDate(String date){
        if(date.contains("T")) {
            List<String> dateList = Arrays.asList(date.split("T"));
            return dateList.stream().findFirst();
        }
        return Optional.empty();
    }
}
