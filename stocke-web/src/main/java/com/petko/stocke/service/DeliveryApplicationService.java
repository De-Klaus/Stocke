package com.petko.stocke.service;

import com.petko.stocke.constants.Keys.CP;
import com.petko.stocke.constants.Keys.STATUS;
import com.petko.stocke.model.CaseApplication;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class DeliveryApplicationService {


    /**
     * Receiving all requests for issuance from the warehouse
     * @return
     */
    public static List<CaseApplication> getDeliveryApplications() {
        List<CaseApplication> apList = new ArrayList<>();
        addApplicationStock(apList);
        log.debug("addApplicationStock: "+apList.size());
        addApplicationStockAndProductCut(apList);
        log.debug("getDeliveryApplications: "+apList.size());
        return apList;
    }

    /**
     * Receiving all requests for the issuance of products through the portlet
     * @param storageApplications
     */
    private static void addApplicationStock(List<CaseApplication> storageApplications) {
        List<CaseApplication> applications = ApplicationService.getApplications(CP.CP_REQUEST);
        log.debug("ApplicationsStock: " + applications.size());
        if(!applications.isEmpty()&&applications.size()>0)
            storageApplications.addAll(applications);
    }

    /**
     * Receipt of applications for the issuance of products by Case
     * @param storageApplications
     */
    private static void addApplicationStockAndProductCut(List<CaseApplication> storageApplications) {
        List<CaseApplication> applications = ApplicationService.getApplications(CP.CP_PRODUCT_DELIVERY, STATUS.PRODUCTS_DELIVERED);
        log.debug("ApplicationsCut: " + applications.size());
        if(!applications.isEmpty()&&applications.size()>0)
            storageApplications.addAll(applications);
    }





}
