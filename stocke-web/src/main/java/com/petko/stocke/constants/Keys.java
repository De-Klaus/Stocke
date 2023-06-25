package com.petko.stocke.constants;

public interface Keys {

    interface CP {
        long CP_PERSON           = 401L;
        long CP_REQUEST          = 402L;
        long CP_MINE             = 701L;
        long CP_STORE            = 702L;
        long CP_PRODUCT_DELIVERY = 705L;
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
        String STOREYS                  = "storeys";
        String REMAINDER                = "remainder";
        String BALANCE                  = "balance";
        String USER_ID_LF               = "userIdLf";
        String PURCHASE_DESIRED         = "purchaseDesired";
        String ORG_ID_LF                = "orgIdLf";
        String DATA_GRID_2              = "dataGrid2";
        String GRADE                    = "Grade";
        String VALUE                    = "value";
        String COUNT                    = "Count";
        String ORG                      = "org";
        String REQUEST                  = "request";
        String RECIPIENT_ID             = "recipientId";
        String ADD_LIMIT                = "addLimit";
        String STOREKEEPER_ID           = "storekeeperId";
        String ORG_ID                   = "orgId";
        String PARAMS_HANDLER_DATA      = "params_handler_data";

        String STORAGE_NAME             = "storage_name";
        String STOREKEEPER_LASTNAME     = "storekeeper_lastname";
        String STOREKEEPER_FIRSTNAME    = "storekeeper_firstname";
        String STOREKEEPER_MIDDLENAME   = "storekeeper_middlename";
        String STORAGE_ID               = "storage_id";
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
