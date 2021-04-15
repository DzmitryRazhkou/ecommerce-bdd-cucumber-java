package com.app.constants;

/**
 * This class contains the title and URL of page object classes
 * URL can't be verified entirely because its ending is generated,
 * but we can still verify its beginning.
 * @author Muana Kimba
 */
public final class PageInfo {

	// CONTRUCTEUR
	private PageInfo() throws Exception {
		throw new Exception();
	}
	
	// COMMUN
	public static final String URL_START = System.getProperty("app.url");
	private static final String URL_END = "index/key/";

	// SIGN_IN PAGE
	public static final String SIGN_IN_PAGE_TITLE = "Magento Admin";
	public static final String SIGN_IN_PAGE_URL = URL_START + "admin/index/" + URL_END;

	// DASHBOARD PAGE
	public static final String DASHBOARD_PAGE_TITLE = "Dashboard / Magento Admin";
	public static final String DASHBOARD_PAGE_URL = URL_START + "admin/dashboard/" + URL_END;
}