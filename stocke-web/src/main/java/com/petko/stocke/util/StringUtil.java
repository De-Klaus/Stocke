package com.petko.stocke.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtil {

    /**
     * Проверка на наличие только цифр в строке и точки
     * @param input
     * @return
     */
    public static boolean isNumericDouble(String input) {
        if(input.contains(".")){
            input = input.replace(".","");
        }

        CharSequence cs = input;
        if (isEmpty(cs)) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

    private static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }


    /**
     * Проверка входного значения на число и возвращения числа
     * @param input
     * @return
     */
    public static Long checkAndGetNumeric(Object input) {
        if(!isNumeric(input))
            return 0L;
        return Long.valueOf(String.valueOf(input));
    }

    /**
     * Проверка на наличие только цифр в строке
     * @param input
     * @return
     */
    public static boolean isNumeric(Object input) {
        CharSequence cs = String.valueOf(input);
        if (isEmpty(cs)) {
            return false;
        } else {
            int sz = cs.length();

            for(int i = 0; i < sz; ++i) {
                if (!Character.isDigit(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        }
    }

}
