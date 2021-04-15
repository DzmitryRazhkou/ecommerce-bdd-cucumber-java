package com.app.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;
import io.cucumber.java.fr.Soit;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.app.hooks.AppHook;
import com.app.pageObjects.SignInPage;
import com.app.utils.DriverFactory;

public class SignInSteps {
	
	// VARIABLES D'INSTATNCE
	private SignInPage signInPage;
		
	// ÉTAPES
	@Soit("^un navigateur est ouvert$")
	public void un_navigateur_est_ouvert() {
		AppHook.openBrowser();
	}
	
	@Quand("^je me rend sur le site admin de l'application$")
	public void je_me_rend_sur_le_site_admin_de_l_application() {
		AppHook.openApp();
		signInPage = new SignInPage(DriverFactory.getDriver());
	}
	
	@Quand("^je me connecte avec les identifiants suivants:$")
	public void je_me_connecte_avec_mes_identifiants(DataTable identifiants) {
		List<Map<String, String>> data = identifiants.asMaps();
		
		signInPage.signIn(data.get(0).get("nom_utilisateur"), data.get(0).get("mot_de_passe"));
	}
	
	@Quand("^je me connecte avec le nom d'utilisateur \"(.*)\" et le mot de passe \"(.*)\"$")
	public void je_me_connecte_avec_le_nom_d_utilisateur_et_le_mot_de_passe(String nom_utilisateur, String mot_de_passe) {
		signInPage.enterUsername(nom_utilisateur.replace("\"", ""));
	    signInPage.enterPassword(mot_de_passe.replace("\"", ""));
	    signInPage.clickSignIn();
	}
	
	@Alors("^un message d'erreur concernant le nom d'utilisateur s'affiche$")
	public void un_message_d_erreur_concernant_le_nom_d_utilisateur_s_affiche() {
		assertTrue(signInPage.isUsernameErrorMessageDisplayed());
	}
	
	@Alors("^un message d'erreur concernant le mot de passe s'affiche$")
	public void un_message_d_erreur_concernant_le_mot_de_passe_s_affiche() {
		assertTrue(signInPage.isPasswordErrorMessageDisplayed());
	}
}