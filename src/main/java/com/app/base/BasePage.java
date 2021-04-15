package com.app.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Cette classe est héritée par la classe Page et par les classes pageComponents.
 * Elle leur fournit des méthodes communes pour intéragir avec les éléments web.
 * @author Muana Kimba
 */
public abstract class BasePage {
	
	// VARIABLES DE CLASSE
	protected static final long TIMEOUT = 15;
	protected static final long MESSAGE_TIMEOUT = 3;
	
	// VARIABLES D'INSTANCE
	protected WebDriver driver;
	
	// CONSTRUCTEUR
	protected BasePage(WebDriver driver) {
		this.driver = driver;
	}

	// MÉTHODES
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//												CLIQUER
	protected void click(By locator) {
		driver.findElement(locator).click();
	}
	protected void click(By locator, long timeout) {
		elementToBeClickable(locator, timeout).click();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//												ENTRER TEXTE
	protected void enterText(By locator, String text) {
		if(text.isEmpty())	// for testdata to not enter any text in the field
			return;
		
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	//										ATTENTE POUR LOCALISATEURS
	//	VISIBILITÉ
	protected boolean isElementLocatedVisible(By locator, long timeout) {
		try {
			visibilityOfElementLocated(locator, timeout);
			return true;
		}
		catch(TimeoutException te) {
			return false;
		}
	}
	protected WebElement visibilityOfElementLocated(By locator, long timeout) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	protected boolean invisibilityOfElementLocated(By locator, long timeout) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	protected List<WebElement> visibilityOfAllElementsLocatedBy(By locator, long timeout) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	//	CLIQUABILITÉ
	protected WebElement elementToBeClickable(By locator, long timeout) {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator));
	}
}