package com.app.stepDefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.app.constants.PageInfo;
import com.app.context.TestContext;
import com.app.hooks.AppHook;
import com.app.pageObjects.DashboardPage;
import com.app.pageObjects.SignInPage;

import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Soit;

public class CommonSteps {

	// VARIABLES D'INSTATNCE
	private SignInPage signInPage;
	private DashboardPage dashboardPage;

	// INJECTION AVEC PicoContainer
	public CommonSteps(TestContext testContext) {
		signInPage = testContext.getSignInPage();
		dashboardPage = testContext.getDashboardPage();
	}
	
	// ÉTAPES
	//										je suis sur la page...
	@Alors("^je suis sur la page de connexion$")
	public void je_suis_sur_la_page_de_connexion() {
		assertEquals(PageInfo.SIGN_IN_PAGE_TITLE, signInPage.getTitle());
		assertTrue(signInPage.getURL().startsWith(PageInfo.SIGN_IN_PAGE_URL));
	}
	
	@Soit("^je suis sur la page du tableau de bord$")
	public void je_suis_sur_la_page_du_tableau_de_bord() {
		assertEquals(PageInfo.DASHBOARD_PAGE_TITLE, dashboardPage.getTitle());
		assertTrue(dashboardPage.getURL().startsWith(PageInfo.DASHBOARD_PAGE_URL));
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//								je suis connecté à l'application
	@Soit("^je suis connecté à l'application$")
	public void je_suis_connecté_à_l_application() {
		signInPage.signIn(
				AppHook.properties.getProperty("NOM_UTILISATEUR"), AppHook.properties.getProperty("MOT_DE_PASSE")
				).waitForOverlayIfPresent().clickAdminNotificationDontAllowUsageIfPresent();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//
}