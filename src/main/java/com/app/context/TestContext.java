package com.app.context;

import com.app.pageObjects.DashboardPage;
import com.app.pageObjects.SignInPage;
import com.app.utils.DriverFactory;

/**
 * Cette classe sert de contexte où de partage de données entre les étapes
 * de chaque scénario de test.
 * 
 * Les méthodes "Getters" retournent les pageObjects s'ils existent sinon,
 * elles en créent de nouvelles. 
 * 
 * Les méthodes "Setters" affectent aux références des pageObjects
 * les transitions de pages.
 * @author Muana Kimba
 */
public class TestContext {
	
	private SignInPage signInPage;
	private DashboardPage dashboardPage;
	
	public SignInPage getSignInPage() {
		return signInPage == null ? signInPage = new SignInPage(DriverFactory.getDriver()) : signInPage;
	}
	public DashboardPage getDashboardPage() {
		return dashboardPage == null ? dashboardPage = new DashboardPage(DriverFactory.getDriver()) : dashboardPage;
	}
	
	public void setSignInPage(SignInPage signInPage) {
		this.signInPage = signInPage;
	}
	public void setDashboardPage(DashboardPage dashboardPage) {
		this.dashboardPage = dashboardPage;
	}
}