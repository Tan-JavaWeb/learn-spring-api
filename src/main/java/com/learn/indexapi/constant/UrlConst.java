package com.learn.indexapi.constant;

/**
 * API Request
 */
public final class UrlConst {
	
//	public static final String CROSSORIGIN = "http://localhost:4200";
	
	public static final String CROSSORIGIN = "*";

	public static final String API_V_1 = "/api/v1";

	public static final String DEMO = API_V_1 + "/getAllDemo";
	
	public static final String HOME_LINK = API_V_1 + "/homelink";
	
	public static final String HOME_LINK_BY_ID = API_V_1 + "/homelink/{id}";
	
	public static final String HOME_LINK_UPDATE = API_V_1 + "/homelink/update/{id}";
	
	public static final String HOME_LINK_DELETE = API_V_1 + "/homelink/delete/{id}";
	
	public static final String LINK_HOME_PAGE_DETAIL = API_V_1 + "/homelinkdetail";
}