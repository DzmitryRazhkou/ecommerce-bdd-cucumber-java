package com.app.pageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.base.BasePage;
import com.app.pageObjects.SignInPage;

public class PageHeader extends BasePage {

	// ÉLÉMENTS WEB STATIQUE
	private static final By USER_MENU = By.xpath("//a[@title='My Account']");

	// ÉLÉMENTS WEB DYNAMIQUE
	private static final By USER_MENU_SIGN_OUT = By.xpath("//a[@title='Sign Out']");

	// INITIALISATION DE LA COMPOSANTE DE PAGE
	public PageHeader(WebDriver driver) {
		super(driver);
	}

	// ACTIONS UTILISATEUR
	public SignInPage signOut() {
		click(USER_MENU);
		click(USER_MENU_SIGN_OUT, TIMEOUT);
		
		return new SignInPage(driver);
	}
}