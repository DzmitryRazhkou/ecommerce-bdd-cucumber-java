package com.app.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.base.Page;

public class SignInPage extends Page {

	// LOCALISATEURS D'ÉLÉMENT WEB
	// statique
	private static final By USERNAME_FIELD = By.id("username");
	private static final By PASSWORD_FIELD = By.id("login");
	private static final By SIGN_IN_BUTTON = By.xpath("//button/span[text()='Sign in']");
	private static final By LOGOUT_SUCCESS_MESSAGE = By.xpath("//div[@data-ui-id='messages-message-success']");
	// dynamique
	private static final By USERNAME_ERROR_MESSAGE = By.id("username-error");
	private static final By PASSWORD_ERROR_MESSAGE = By.id("login-error");

	// INITIALISATION DE LA PAGE
	public SignInPage(WebDriver driver) {
		super(driver);
	}

	// ACTIONS UTILISATEUR
	// simples
	public void enterUsername(String username) {
		enterText(USERNAME_FIELD, username);
	}
	public void enterPassword(String password) {
		enterText(PASSWORD_FIELD, password);
	}
	public void clickSignIn() {
		click(SIGN_IN_BUTTON);
	}
	// composées
	public DashboardPage signIn(String username, String password) {
		enterText(USERNAME_FIELD, username);
		enterText(PASSWORD_FIELD, password);
		click(SIGN_IN_BUTTON);
		
		return new DashboardPage(driver);
	}

	// VALIDATION
	public boolean isUsernameErrorMessageDisplayed() {
		return isElementLocatedVisible(USERNAME_ERROR_MESSAGE, MESSAGE_TIMEOUT);
	}
	public boolean isPasswordErrorMessageDisplayed() {
		return isElementLocatedVisible(PASSWORD_ERROR_MESSAGE, MESSAGE_TIMEOUT);
	}
	public boolean isLogoutSuccessMessageDisplayed() {
		return isElementLocatedVisible(LOGOUT_SUCCESS_MESSAGE, MESSAGE_TIMEOUT);
	}
}