package com.app.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Cette classe est héritée par la classe SignInPage et par les classes pageObjects
 * @author Muana Kimba
 */
public abstract class Page extends BasePage {
	
	// VARIABLES DE CLASSE
	private static final long PAGE_LOAD_TIMEOUT = Long.parseLong(System.getProperty("temps.de.chargement.de.page"));
	
	// CONSTRUCTEUR
	public Page(WebDriver driver) {
		super(driver);
		waitForReadyState();
	}
	
	/**
	 * This method is useful to wait for a particular page to load
	 * once it gets instantiated
	 * Cette méthode est pratique pour attendre après le chargement
	 * d'une page nouvellement instanciée.
	 */
	private void waitForReadyState() {
		WebDriverWait wait = new WebDriverWait(driver, PAGE_LOAD_TIMEOUT);

	    wait.until(new ExpectedCondition<Boolean>() {
	        public Boolean apply(WebDriver wdriver) {
	            return ((JavascriptExecutor) driver).executeScript(
	                "return document.readyState"
	            ).equals("complete");
	        }
	    });
	}

	// MÉTHODES
	public String getTitle() {
		return driver.getTitle();
	}
	public String getURL() {
		return driver.getCurrentUrl();
	}
}