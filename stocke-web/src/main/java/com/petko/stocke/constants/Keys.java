package com.petko.stocke.constants;

public interface Keys {

    interface BP {
        long BP_PERSON           = 401L;    //Номер БП "Домовладение"
        long BP_REQUEST          = 402L;    //Номер БП "Заявка на выдачу угольной продукции"
        long BP_MINE             = 701L;    //Номер БП "КАРТОЧКА: Разрез"
        long BP_STORE            = 702L;    //Номер БП "КАРТОЧКА: Склад"
        long BP_PRODUCT_DELIVERY = 705L;    //Номер БП "ПРОЦЕСС: Доставка продукции"
    }

    interface API {
        String CONTACT_ID       = "contactId";
        String USER_ID          = "userId";
        String LASTNAME         = "lastname";
        String FIRSTNAME        = "firstname";
        String MIDDLENAME       = "middlename";
        String BIRTHDATE        = "birthdate";
        String SNILS            = "snils";
        String TOWN             = "town";
        String STREET           = "street";
        String HOUSE            = "house";
        String FLAT             = "flat";
        String SQUARE           = "square";
        String NUMBER           = "number";
        String KOF              = "kof";
        String STOREYS          = "storeys";
        String REMAINDER        = "remainder";
        String USER_ID_LF       = "userIdLf";
        String PURCHASE_DESIRED = "purchaseDesired";
        String ORG_ID_LF        = "orgIdLf";
        String DATA_GRID_2      = "dataGrid2";
        String COAL_GRADE       = "coalGrade";
        String NO_PREY          = "noPrey";
        String VALUE            = "value";
        String LABEL            = "label";
        String COAL_COUNT       = "coalCount";
        String COAL_STORAGE_NAME= "coalstorage_name";
        String COAL_STORAGE_ID  = "coalstorage_id";
        String ORG              = "org";
        String REQUEST          = "request";
        String KEY              = "key";
        String HTML             = "html";

    }
    interface ApiValue {
        String WARNING = "warning";
    }
    interface STATUS {
        String PRODUCTS_DELIVERED = "Продукция доставлена";
    }



}
