package com.petko.stocke.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.petko.stocke.model.CaseApplication;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import com.petko.stocke.dto.OrgPurchaseDto;
import com.petko.stocke.constants.Keys.API;
import com.petko.stocke.service.DeliveryApplicationService;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Slf4j
public class StatisticUtil {

    /**
     * Receipt of all types of products
     *
     * @return
     */
    public static List<OrgPurchaseDto> getAllStorageNames() {
        DeliveryApplicationService deliveryApplicationService = new DeliveryApplicationService();
        List<CaseApplication> applications = deliveryApplicationService.getDeliveryApplications();
        return applications.stream().map(CaseApplication::getAdditionalFields)
                .map(field->
                        getOrgName(field))
                .distinct()
                .filter(f->
                        !f.equals(StringPool.BLANK))
                .map(orgName->createOrgPurchase(orgName))
                .filter(orgPurchase -> orgPurchase!=null)
                .collect(Collectors.toList());
    }

    /**
     * Retrieving all organization names from tickets
     * @param field
     * @return
     */
    private static String getOrgName(String field) {
        JSONObject jsonField = new JSONObject(field);

        if(jsonField.has(API.STORAGE_NAME)){
            String storage_name = jsonField.optString(API.STORAGE_NAME);
            if (!Validator.isBlank(storage_name))
                return storage_name;
        }

        else if(jsonField.has(API.ORG)){
            String storage_name = jsonField.optString(API.ORG);
            if (!Validator.isBlank(storage_name))
                return storage_name;
        }
        return StringPool.BLANK;
    }

    /**
     * Create entity OrgPurchase
     * @param orgName
     * @return
     */
    private static OrgPurchaseDto createOrgPurchase(String orgName) {
        Optional<OrgPurchaseDto> optOrgPurchase = OrganizationLocalServiceUtil.getOrganizations(-1,-1).stream()
                .filter(org -> org.getName().equals(orgName))
                .map(org -> new OrgPurchaseDto(org.getOrganizationId(), orgName, true))
                .findFirst();
        return optOrgPurchase.isPresent() ? optOrgPurchase.get() : null;
    }

    /**
     * Adding selected select components after applying a filter
     * @param storage
     * @param filterStorage
     * @return
     */
    public static List<OrgPurchaseDto> getShowSelected(List<OrgPurchaseDto> storage, String[] filterStorage) {
        log.info(Arrays.asList(filterStorage).toString());
        List<OrgPurchaseDto> arraySelect = new ArrayList<>();
        if(filterStorage!=null && filterStorage.length>0){
            storage.stream().forEach(iter->{
                boolean sel = false;
                for(String store : filterStorage){
                    String iterOrgId = String.valueOf(iter.getOrgId());
                    if(iterOrgId.equals(store))
                        sel = true;
                }
                iter.setShow(sel);
                arraySelect.add(iter);
            });
        } else
            storage.stream().forEach(iter->{
                iter.setShow(false);
                arraySelect.add(iter);
            });
        return arraySelect.stream()
                .sorted(Comparator.comparing(a -> (a.getOrgId())))
                .collect(Collectors.toList());
    }
}
