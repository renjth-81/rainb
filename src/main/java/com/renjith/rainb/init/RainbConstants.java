package com.renjith.rainb.init;

public class RainbConstants {

	public static final int USER_ROLE_ID = 2;
	public static final int ADMIN_ROLE_ID = 1;

	public static final String USER_ROLE_NAME = "ROLE_USER";
	public static final String ADMIN_ROLE_NAME = "ROLE_ADMIN";

	public static final String USER_LOGIN_SUCCESS_PAGE = "/usr";
	public static final String ADMIN_LOGIN_SUCCESS_PAGE = "/adm";

	public static final String LOGIN_PAGE_TIMEOUT = "/login?timeout";
	public static final String ERROR_PAGE = "/error";

	public static final String ERROR_PAGE_MESSAGE_ATTRIBUTE = "errMsg";
	public static final String ACCESS_DENIED_ERR_MSG = "Access denied!!";
	public static final String PAYMENT_ERR_MSG = "Payment error. Please try again";

	public static final String LOGIN_STATUS = "loginStatus";
	public static final String LOGIN_STATUS_YES = "yes";
	public static final String LOGIN_STATUS_NO = "no";

	public static final String ROLE = "role";

	public static final String[] pagesAfterLogin = { "usr","adm" };

	public static final String[] pagesBeforeLogin = { "home", "login" };

}
