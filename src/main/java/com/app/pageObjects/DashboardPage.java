package com.app.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.app.base.Page;
import com.app.pageComponents.PageNavigation;
import com.app.pageComponents.PageHeader;

public class DashboardPage extends Page {
	
	// LOCALISATEURS D'ÉLÉMENT WEB
	// dynamique
	private static final By LOADING_OVERLAY = By.className("admin__form-loading-mask");
	private static final By ADMIN_NOTIFICATION_OVERLAY = By.xpath("aside[contains(@class,'_show')]");
	private static final By ADMIN_NOTIFICATION_DONT_ALLOW_USAGE_BUTTON = By.xpath("//button[@class='action-secondary']");
	private static final By LOADING_MASK = By.cssSelector(".loading-mask");
	
	// COMPOSANTES DE PAGE
	public PageNavigation adminNavigation;
	public PageHeader pageHeader;
	
	// INITIALISATION DE LA PAGE
	public DashboardPage(WebDriver driver) {
		super(driver);
		adminNavigation = new PageNavigation(driver);
		pageHeader = new PageHeader(driver);
	}
	
	// ACTIONS UTILISATEUR
	public DashboardPage clickAdminNotificationDontAllowUsageIfPresent() {
		if(isElementLocatedVisible(ADMIN_NOTIFICATION_DONT_ALLOW_USAGE_BUTTON, MESSAGE_TIMEOUT)) {
			click(ADMIN_NOTIFICATION_DONT_ALLOW_USAGE_BUTTON, TIMEOUT);
			invisibilityOfElementLocated(ADMIN_NOTIFICATION_OVERLAY, TIMEOUT);
			invisibilityOfElementLocated(LOADING_MASK, TIMEOUT);
			
			waitForOverlayIfPresent();
		} 
		return this;
	}
	
	// ATTENTTES
	public DashboardPage waitForOverlayIfPresent() {
		if(isElementLocatedVisible(LOADING_OVERLAY, MESSAGE_TIMEOUT))
			invisibilityOfElementLocated(LOADING_OVERLAY, TIMEOUT);
		return this;
	}
}