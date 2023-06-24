package com.petko.stocke.service;

import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.petko.stocke.constants.Keys.API;
import lombok.extern.slf4j.Slf4j;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.util.Map;

@Slf4j
public class SaveFileService {


    /**
     * Receiving the generated file and sending it for download
     * @param pdfParams
     * @return
     */
    public static void collectPdfQrDoc(ResourceRequest request, ResourceResponse response, Map<String, String> pdfParams, byte[] pdfQrBytes)  {
        String fileName = pdfParams.get(API.NAME_PDF);
        try {
            log.debug("Saving a file");
            downloadPdfQrDoc(request, response, fileName, pdfQrBytes);
        }
        catch (Exception exception){
            log.error("Error saving pdf file", exception);
            throw new RuntimeException("Error saving pdf file", exception);
        }

    }


    /**
     * Download pdf file
     * @param request
     * @param response
     * @param fileName
     * @param pdfQrBytes
     * @return
     */
    public static void downloadPdfQrDoc(ResourceRequest request, ResourceResponse response, String fileName, byte[] pdfQrBytes)  {
        try {
            log.debug("Загрузка файла");
            PortletResponseUtil.sendFile(request, response, fileName, pdfQrBytes,
                    ContentTypes.APPLICATION_PDF);
        }
        catch (Exception exception){
            log.error("Ошибка при загрузки файла pdf", exception);
            throw new RuntimeException("Ошибка при формировании файла pdf", exception);
        }
    }


}
