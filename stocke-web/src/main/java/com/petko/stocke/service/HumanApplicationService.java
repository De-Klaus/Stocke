package com.petko.stocke.service;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.petko.stocke.constants.Keys.API;
import com.petko.stocke.constants.Keys.CP;
import com.petko.stocke.dto.HumanDto;
import com.petko.stocke.model.CaseApplication;
import com.petko.stocke.util.CalculateUtil;
import com.petko.stocke.util.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
public class HumanApplicationService {

    /**
     * Find in the BP "Register of Individuals" according to SNILS the application number with the person's data
     *
     * @param snils
     */
    public static long findIdBySnils(String snils) {
        Optional<Long> optId = ApplicationService.getApplications(CP.CP_PERSON).stream()
                .filter(app ->
                    CheckUtil.checkMatchInn(app.getAdditionalFields(), snils))
                .map(app -> app.getId())
                .findFirst();
        return optId.isPresent() ? optId.get() : 0L;
    }

    /**
     * Find in the BP "Register of Individuals" by full name and date of birth the application number with the person's data
     *
     * @param lastname
     * @param firstname
     * @param middlename
     * @param birthdate  - form is yyyy-MM-dd
     */
    public static long findByFioAndBirthDay(String lastname, String firstname, String middlename, String birthdate) {
        Optional<Long> optId = ApplicationService.getApplications(CP.CP_PERSON).stream()
                .filter(app ->
                        CheckUtil.checkMatchFioAndBirthDay(
                                app.getAdditionalFields(),
                                lastname,
                                firstname,
                                middlename,
                                birthdate))
                .map(app -> app.getId())
                .findFirst();
        return optId.isPresent() ? optId.get() : 0L;
    }

    /**
     * Get the human
     * @param id
     * @return
     * @throws PortalException
     */
    public static Optional<HumanDto> getHuman(long id) {
        HumanDto human = null;
        try {
            CaseApplication app     = CaseApplicationLocalServiceUtil.getCaseApplication(id);
            String dataJSON         = app.getAdditionalFields();
            JSONObject dataForm     = new JSONObject(dataJSON);

            String lastname         = dataForm.optString(API.LASTNAME);
            String firstname        = dataForm.optString(API.FIRSTNAME);
            String middlename       = dataForm.optString(API.MIDDLENAME);
            String birthdate        = dataForm.optString(API.BIRTHDATE);
            String snils            = dataForm.optString(API.SNILS);
            String town             = dataForm.optString(API.TOWN);
            String street           = dataForm.optString(API.STREET);
            String house            = dataForm.optString(API.HOUSE);
            String flat             = dataForm.optString(API.FLAT);
            double square           = Double.parseDouble(CheckUtil.checkForLetters(dataForm, API.SQUARE));
            double coefficient      = Double.parseDouble(CheckUtil.checkForLetters(dataForm, API.NUMBER));
            int storeys             = Integer.parseInt(CheckUtil.checkForLetters(dataForm, API.STOREYS));
            double remainder        = Double.parseDouble(CheckUtil.checkForLetters(dataForm, API.REMAINDER));
            human                   = new HumanDto(id, lastname, firstname,
                    middlename, birthdate, snils, town, street, house,
                    flat, square, coefficient, storeys, remainder);
        } catch (PortalException e){
            e.printStackTrace();
        }
        return Optional.ofNullable(human);
    }

    /**
     * Update data
     * @param human
     * @throws PortalException
     */
    public static void updateHuman(HumanDto human, long contactId, long userId) throws PortalException {
        CaseApplication app = CaseApplicationLocalServiceUtil.getCaseApplication(human.getId());
        boolean changed = false;
        String dataJSON = app.getAdditionalFields();
        JSONObject dataForm = new JSONObject(dataJSON);
        dataForm.put(API.CONTACT_ID, contactId);
        dataForm.put(API.USER_ID, userId);
        String lastname = dataForm.optString(API.LASTNAME);
        if (!human.getLastname().equals(lastname)) {
            dataForm.put(API.LASTNAME, human.getLastname());
            changed = true;
        }
        String firstname = dataForm.optString(API.FIRSTNAME);
        if (!human.getFirstname().equals(firstname)) {
            dataForm.put(API.FIRSTNAME, human.getFirstname());
            changed = true;
        }
        String middlename = dataForm.optString(API.MIDDLENAME);
        if (!human.getMiddlename().equals(middlename)) {
            dataForm.put(API.MIDDLENAME, human.getMiddlename());
            changed = true;
        }
        String birthdate = dataForm.optString(API.BIRTHDATE);
        if (!human.getBirthdate().equals(birthdate)) {
            dataForm.put(API.BIRTHDATE, human.getBirthdate());
            changed = true;
        }
        String snils = dataForm.optString(API.SNILS);
        if (!human.getSnils().equals(snils)) {
            dataForm.put(API.SNILS, human.getSnils());
            changed = true;
        }
        String town = dataForm.optString(API.TOWN);
        if (!human.getTown().equals(town)) {
            dataForm.put(API.TOWN, human.getTown());
            changed = true;
        }
        String street = dataForm.optString(API.STREET);
        if (!human.getStreet().equals(street)) {
            dataForm.put(API.STREET, human.getStreet());
            changed = true;
        }
        String house = dataForm.optString(API.HOUSE);
        if (!human.getHouse().equals(house)) {
            dataForm.put(API.HOUSE, human.getHouse());
            changed = true;
        }
        String flat = dataForm.optString(API.FLAT);
        if (!human.getFlat().equals(flat)) {
            dataForm.put(API.FLAT, human.getFlat());
            changed = true;
        }
        double square = dataForm.optDouble(API.SQUARE);
        if (Math.abs(square - human.getSquare()) > 0.01) {
            dataForm.put(API.SQUARE, human.getSquare());
            changed = true;
        }
        int storeys = dataForm.optInt(API.STOREYS);
        if (!(human.getStoreys() == storeys)) {
            dataForm.put(API.FLAT, human.getFlat());
            changed = true;
        }
        if (app.getId()!=0){
            dataForm.put(API.USER_ID_LF, app.getId());
        }
        if (changed) {
            app.setAdditionalFields(dataForm.toString());
            app.persist();
            CaseApplicationLocalServiceUtil.updateCaseApplication(app);
        }
    }

    /**
     * Issuance of products from the warehouse
     *
     * @param param
     * @return
     * @throws PortalException
     */
    public static long approve(Map<String,String> param) throws PortalException{
        Long recipientId    = Long.parseLong(param.get(API.RECIPIENT_ID));
        double addLimit     = Double.parseDouble(param.get(API.ADD_LIMIT));
        Long storekeeperId  = Long.parseLong(param.get(API.STOREKEEPER_ID));
        Long orgId          = Long.parseLong(param.get(API.ORG_ID));
        // Update data
        JSONObject physicAppData = addHistoryDelivery(recipientId, addLimit);
        // Create application delivery
        Map<String, Object> params = createApplicationDelivery(addLimit, storekeeperId, physicAppData,orgId);
        return save(params);
    }

    /**
     * Adding a product issuance history to the card
     * @param recipientId
     * @param addLimit
     * @return
     * @throws PortalException
     */
    private static JSONObject addHistoryDelivery(Long recipientId, double addLimit) throws PortalException {
        CaseApplication app = CaseApplicationLocalServiceUtil.getCaseApplication(recipientId);
        String dataJSON = app.getAdditionalFields();
        JSONObject physicAppData = new JSONObject(dataJSON);

        BigDecimal remainderNew  = CalculateUtil.countProduceProduct(addLimit, physicAppData);
        BigDecimal balanceNew    = CalculateUtil.countBalanceProduct(addLimit, physicAppData);

        physicAppData.put(API.REMAINDER, remainderNew);
        physicAppData.put(API.BALANCE, balanceNew);
        physicAppData.put(API.USER_ID_LF,app.getId());

        app.setAdditionalFields(physicAppData.toString());
        app.persist();
        CaseApplicationLocalServiceUtil.updateCaseApplication(app);
        return physicAppData;
    }


    /**
     * Creation of an application for the issuance products
     * @param request
     * @param storekeeperId
     * @param dataForm
     * @return
     * @throws PortalException
     */
    private static Map<String, Object> createApplicationDelivery(double request, long storekeeperId, JSONObject dataForm, Long orgId) throws PortalException {
        Map<String, Object> params = new HashMap<>();
        User storekeeper = UserLocalServiceUtil.getUserById(storekeeperId);
        dataForm.put(API.STOREKEEPER_LASTNAME,      storekeeper.getLastName().trim());
        dataForm.put(API.STOREKEEPER_FIRSTNAME,     storekeeper.getFirstName().trim());
        dataForm.put(API.STOREKEEPER_MIDDLENAME,    storekeeper.getMiddleName().trim());
        Organization storage = OrganizationLocalServiceUtil.getOrganization(orgId);
        dataForm.put(API.STORAGE_ID,                storage.getOrganizationId());
        dataForm.put(API.STORAGE_NAME,          storage.getName().trim());
        dataForm.put(API.REQUEST,                   request);
        params.put(API.PARAMS_HANDLER_DATA,         dataForm);
        return params;
    }


    /**
     * Retention of the statement
     * @param params
     * @return
     */
    private static long save(Map<String, Object> params) {
        CaseApplication application =
                CaseApplicationLocalServiceUtil.createCaseApplication(
                        CounterLocalServiceUtil.increment(CaseApplication.class.getName()));
        application.setStartDate(Calendar.getInstance().getTime());
        JSONObject object = new JSONObject(String.valueOf(params.get(API.PARAMS_HANDLER_DATA)));
        application.setAdditionalFields(object.toString());
        application.persist();
        return application.getId();
    }

}
