package com.app.stepDefinitions;

import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Et;

import static org.junit.Assert.assertTrue;

import com.app.context.TestContext;
import com.app.pageObjects.DashboardPage;
import com.app.pageObjects.SignInPage;

public class SignOutSteps {
	
	// VARIABLES D'INSTATNCE
	private SignInPage signInPage;
	private DashboardPage dashboardPage;
			
	// INJECTION AVEC PicoContainer
	public SignOutSteps(TestContext testContext) {
		dashboardPage = testContext.getDashboardPage();
	}
	
	// ÉTAPES
	@Quand("^je me déconnecte de l'application$")
	public void je_me_déconnecte_de_l_application() {
		signInPage = dashboardPage.pageHeader.signOut();
	}

	@Et("^un message confirmant la déconnexion est affiché$")
	public void un_message_confirmant_la_déconnexion_est_affiché() {
		assertTrue(signInPage.isLogoutSuccessMessageDisplayed());
	}
}