package com.petko.stocke.constants;

public interface Keys {

    interface CP {
        long CP_PERSON           = 401L;    //Номер БП "Домовладение"
        long CP_REQUEST          = 402L;    //Номер БП "Заявка на выдачу угольной продукции"
        long CP_MINE             = 701L;    //Номер БП "КАРТОЧКА: Разрез"
        long CP_STORE            = 702L;    //Номер БП "КАРТОЧКА: Склад"
        long CP_PRODUCT_DELIVERY = 705L;    //Номер БП "ПРОЦЕСС: Доставка продукции"
    }

    interface QUERY {
        String CASE_MODEL_ID = "CaseModelId";
        String ARCHIVE = "Archive";
        String STATUS = "Status";
    }

    interface API {
        String CONTACT_ID               = "contactId";
        String USER_ID                  = "userId";
        String LASTNAME                 = "lastname";
        String FIRSTNAME                = "firstname";
        String MIDDLENAME               = "middlename";
        String BIRTHDATE                = "birthdate";
        String SNILS                    = "snils";
        String TOWN                     = "town";
        String STREET                   = "street";
        String HOUSE                    = "house";
        String FLAT                     = "flat";
        String SQUARE                   = "square";
        String NUMBER                   = "number";
        String KOF                      = "kof";
        String STOREYS                  = "storeys";
        String REMAINDER                = "remainder";
        String BALANCE                  = "balance";
        String USER_ID_LF               = "userIdLf";
        String PURCHASE_DESIRED         = "purchaseDesired";
        String ORG_ID_LF                = "orgIdLf";
        String DATA_GRID_2              = "dataGrid2";
        String COAL_GRADE               = "coalGrade";
        String NO_PREY                  = "noPrey";
        String VALUE                    = "value";
        String LABEL                    = "label";
        String COAL_COUNT               = "coalCount";
        String ORG                      = "org";
        String REQUEST                  = "request";
        String RECIPIENT_ID            = "recipientId";
        String ADD_LIMIT                = "addLimit";
        String STOREKEEPER_ID           = "storekeeperId";
        String ORG_ID                   = "orgId";
        String GRADES_ITEM              = "gradesItem";
        String PARAMS_HANDLER_DATA      = "params_handler_data";

        String COAL_STORAGE_NAME        = "coalstorage_name";
        String STOREKEEPER_LASTNAME     = "storekeeper_lastname";
        String STOREKEEPER_FIRSTNAME    = "storekeeper_firstname";
        String STOREKEEPER_MIDDLENAME   = "storekeeper_middlename";
        String COALSTORAGE_ID           = "coalstorage_id";
        String COALSTORAGE_NAME         = "coalstorage_name";
        String HUMAN_ID                 = "humanId";
        String NAME_PDF                 = "namePdf";

        String SESSION_ORG_ID         = "session_org_id";
        String PARAMS_HANDLER_REPOSITORY_ID = "params_handler_repository";

    }
    interface ApiValue {
        String WARNING = "warning";
    }
    interface STATUS {
        String PRODUCTS_DELIVERED = "Продукция доставлена";
    }



}
