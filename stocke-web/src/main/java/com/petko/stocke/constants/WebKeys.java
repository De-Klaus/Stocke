package com.petko.stocke.constants;

public interface WebKeys {

	String DELIVERY_NAME=
			"com_petko_stocke_DeliveryPortlet";
	String PERSONAL_NAME=
			"com_petko_stocke_PersonalPortlet";
	String STATISTIC_NAME=
			"com_petko_stocke_StatisticPortlet";
		/**
		 * <p> Параметры полей личного кабинета. Передаются в ActionRequest. </p>
		 */
		interface Personal {
			String PREFIX = "personal";

			interface Request {
				String ID =  "id";
				String LASTNAME =  "lastname";
				String FIRSTNAME =  "firstname";
				String MIDDLENAME =  "middlename";
				String BIRTHDATE =  "birthdate";
				String SNILS =  "snils";
				String TOWN =  "town";
				String STREET =  "street";
				String HOUSE =  "house";
				String FLAT =  "flat";
				String SQUARE =  "square";
				String STOREYS =  "storeys";
				String REMAINDER =  "remainder";
				String LIMIT =  "limit";
			}
		}
	/**
	 * <p> Параметры полей личного кабинета. Передаются в ActionRequest. </p>
	 * @author petko
	 */
	interface Delivery {
		String PREFIX = "delivery";
		String HUMAN_ID = "humanId";
		String SEARCH_ID = "idSearch";
		String APROVE = "aprove";
		String FILE_NAME = "personal.pdf";

		interface Request {
			String ID =  "id";
			String NAMBER =  "namber";
			String DATE_REGISTRATION =  "datereg";
			String STOCK =  "stock";
			String LASTNAME =  "lastname";
			String FIRSTNAME =  "firstname";
			String MIDDLENAME =  "middlename";
			String BIRTHDATE =  "birthdate";
			String ISSUED_LIMIT =  "issued_limit";
			String REMAINING_LIMIT =  "remaining_limit";
			String ADD_LIMIT =  "add_limit";
			String STOREKEEPER_ID =  "storekeeperId";
			String ORG_ID =  "orgId";
			String USER_ID =  "userId";
			String LASTNAME_S =  "lastname_search";
			String FIRSTNAME_S =  "firstname_search";
			String MIDDLENAME_S =  "middlename_search";
			String BIRTHDATE_S =  "birthdate_search";
			String SNILS_S =  "snils_search";
			String GRADES =  "grades";

		}
	}
}