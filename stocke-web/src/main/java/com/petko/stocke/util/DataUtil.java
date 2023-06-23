package com.petko.stocke.util;


import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DataUtil {
    /**
     * Прибавляем 24 часа, чтобы был включительно весь день указанной даты
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
     * Проверка условия попадания заявки в диапазон конкурса
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
}
