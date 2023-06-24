package com.petko.stocke.util;

import com.petko.stocke.constants.Keys.*;
import org.json.JSONObject;

import java.util.Optional;

public class CheckUtil {


    /**
     * Checking for a match of the user by snils
     * @param strJson
     * @return
     */
    public static boolean checkMatchInn(String strJson, String snils){
        JSONObject data = new JSONObject(strJson);
        if(data.has(API.SNILS)){
            String curSnils = data.optString(API.SNILS);
            snils = StringUtil.removeSpaces(snils);
            if(curSnils.equals(snils))
                return true;
        }
        return false;
    }


    /**
     * Checking for a match of the user by full name and date of birth
     * @param strJson
     * @param lastName
     * @param firstName
     * @param middleName
     * @param birthDate
     * @return
     */
    public static boolean checkMatchFioAndBirthDay(String strJson, String lastName, String firstName, String middleName, String birthDate){
        JSONObject data = new JSONObject(strJson);
        if(!checkBirthDay(data, birthDate))
            return false;
        if(!checkLastName(data, lastName))
            return false;
        if(!checkFirstName(data, firstName))
            return false;
        if(!checkMiddleName(data, middleName))
            return false;
        return true;
    }

    /**
     * Date of birth check
     * @param data
     * @param birthdate
     * @return
     */
    public static boolean checkBirthDay(JSONObject data, String birthdate){
        if(data.has(API.BIRTHDATE)) {
            Optional<String> appBirthDate = DateUtil.getSplitDate(data.optString(API.BIRTHDATE));
            if(appBirthDate.isPresent()&&birthdate.equals(appBirthDate.get())){
                return true;
            }
        }
        return false;
    }

    /**
     * Date of lastName check
     * @param data
     * @param lastName
     * @return
     */
    public static boolean checkLastName(JSONObject data, String lastName){
        if(data.has(API.LASTNAME)) {
            String appLastName = data.optString(API.LASTNAME).trim();
            if (appLastName.equals(lastName.trim()))
                return true;
        }
        return false;
    }

    /**
     * Date of firstName check
     * @param data
     * @param firstName
     * @return
     */
    public static boolean checkFirstName(JSONObject data, String firstName){
        if(data.has(API.FIRSTNAME)) {
            String appFirstName = data.optString(API.FIRSTNAME).trim();
            if (appFirstName.equals(firstName.trim()))
                return true;
        }
        return false;
    }


    /**
     * Date of middleName check if there is no middle name, then we return the true
     * @param data
     * @param middleName
     * @return
     */
    public static boolean checkMiddleName(JSONObject data, String middleName){
        if(data.has(API.MIDDLENAME)) {
            String appMiddleName = data.optString(API.MIDDLENAME).trim();
            if (appMiddleName.equals(middleName.trim()))
                return true;
            else
                return false;
        }
        return true;
    }

    /**
     * Checking if a string contains only numbers
     * @param dataForm
     * @param key
     * @return
     */
    public static String checkForLetters(JSONObject dataForm, String key) {
        Object str = "1";
        if(dataForm.has(key))
            str = dataForm.get(key);
        String check = String.valueOf(str);
        return StringUtil.isNumericDouble(check)?check:"0";
    }




}
