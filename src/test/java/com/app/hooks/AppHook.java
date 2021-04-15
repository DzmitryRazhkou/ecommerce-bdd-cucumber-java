package com.app.hooks;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import com.app.constants.PageInfo;
import com.app.utils.DriverFactory;
import com.app.utils.DriverFactory.Browser;
import com.app.utils.DriverFactory.Environment;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Cette classe sert de "hook" pour ouvrir et fermer l'application. 
 * @author Muana Kimba
 */
public class AppHook {
	
	// VARIABLES DE CLASSE
	public static Properties properties;
	
	// HOOKS
	// Cette méthode "hook" n'est pas exécutée pour les scénarios du fichier SignIn.feature
	@Before(value="not @Connexion", order=0)
	public void beforeScenario() {
		openBrowser();
		openApp();
	}
	
	@After(order=0)
	public void afterScenario() {
		DriverFactory.getDriver().quit();
		DriverFactory.removeDriver();
	}
	
	// MÉTHODES D'AIDES
	/* appelé par la méthode "hook" beforeScenario() dans la classe courante
	 * et par la méthode un_navigateur_est_ouvert() dans la classe SignInSteps
	*/
	public static void openBrowser() {
		Environment env = Environment.valueOf(properties.getProperty("ENVIRONNEMENT").trim().toUpperCase());
		Browser browser = Browser.valueOf(properties.getProperty("NAVIGATEUR").trim().toUpperCase());
		
		DriverFactory.setDriver(env, browser, Boolean.parseBoolean(properties.getProperty("SANS_TÊTE")));
		
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().deleteAllCookies();
		DriverFactory.getDriver().manage().timeouts()
			.pageLoadTimeout(Long.parseLong(System.getProperty("temps.de.chargement.de.page")), TimeUnit.SECONDS);
	}
	
	/* appelé par la méthode "hook" beforeScenario() dans la classe courante
	 * et par la méthode je_me_rend_sur_le_site_admin_de_l_application() dans la classe SignInSteps
	*/
	public static void openApp() {
		DriverFactory.getDriver().get(PageInfo.URL_START);
	}
}