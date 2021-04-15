package com.app.pageComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.app.base.BasePage;

public class PageNavigation extends BasePage {
	
	// ÉLÉMENTS WEB STATIQUE
	// un menu
	private static final String MENU_XPATH = "//ul[@id='nav']//a/span[contains(text(), '%s')]";
	// ÉLÉMENTS WEB DYNAMIQUE
	// (menu > sous-menus)	SALES, CATALOG, CUSTOMERS
	private static final String SUB_MENUS_WITHOUT_TITLE_XPATH = "//a/span[text()='%s']/ancestor::li//div//a/span";
	// (menu > titre > sous-menus)	MARKETING, CONTENT, REPORTS, STORES, SYSTEM
	private static final String SUB_MENUS_WITH_TITLE_XPATH = "//a/span[text()='%s']/ancestor::li//span[text()='%s']/ancestor::li[contains(@class, 'level-1')]//a/span";
	
	
	
	// INITIALISATION DE LA COMPOSANTE DE PAGE
	public PageNavigation(WebDriver driver) {
		super(driver);
	}
	
	// ACTIONS
	public void clickMenu(String menu) {
		By menuLocator = By.xpath(String.format(MENU_XPATH, menu));
		click(menuLocator, TIMEOUT);
	}
	
	// GET
	public List<WebElement> getTitleSubMenus(String menu, String title) {
		if(menu.equalsIgnoreCase(title))
			return visibilityOfAllElementsLocatedBy(By.xpath(String.format(SUB_MENUS_WITHOUT_TITLE_XPATH, menu)), TIMEOUT);
			
		return visibilityOfAllElementsLocatedBy(By.xpath(String.format(SUB_MENUS_WITH_TITLE_XPATH, menu, title)), TIMEOUT);
	}
	
	// VALIDATION
	public boolean isMenuDisplayed(String menu) {
		By menuLocator = By.xpath(String.format(MENU_XPATH, menu));
		return isElementLocatedVisible(menuLocator, TIMEOUT);
	}
}