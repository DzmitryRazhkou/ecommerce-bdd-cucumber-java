package com.app.utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.app.constants.FilePaths;

/**
 * Cette classe crée et retourne des pilotes uniques (navigateurs) pour chaque processus (scénario)
 * @author Muana Kimba
 */
public final class DriverFactory {
	
	// VARIABLES DE CLASSE
	private static final ThreadLocal<WebDriver> DRIVERS = new ThreadLocal<>();
	public enum Environment {
		LOCAL,
		REMOTE
	}
	public enum Browser {
		CHROME,
		EDGE,
		FIREFOX
	}
	
	// CONSTRUCTEUR
	private DriverFactory() throws Exception {
		throw new Exception();
	}
	
	// MÉTHODES
	public static void setDriver(Environment environment, Browser browser, boolean headless) {
		switch(environment) {
			case LOCAL:
				setLocalDriver(browser, headless);
				break;
			default:
				URL hub = null;
				try {
					hub = new URL(System.getProperty("hub.url"));
				} catch (MalformedURLException mue) {
					mue.printStackTrace();
				}
				setRemoteDriver(hub, browser, headless);
		}
	}
	
	private static synchronized void setLocalDriver(Browser browser, boolean headless) {
		switch(browser) {
			case EDGE:
				System.setProperty("webdriver.edge.driver", FilePaths.EDGE_BINARY);
				DRIVERS.set(new EdgeDriver());
				break;
			default:
				throw new IllegalArgumentException(browser + " is not supported to run locally! Try with EDGE.");
		}
	}
	
	private static synchronized void setRemoteDriver(URL hub, Browser browser, boolean headless) {
		switch(browser) {
			case CHROME:
				DRIVERS.set(new RemoteWebDriver(hub, new ChromeOptions().setHeadless(headless)));
				break;
				
			case EDGE:
				DRIVERS.set(new RemoteWebDriver(hub, new EdgeOptions()));
				break;
				
			default:
				DRIVERS.set(new RemoteWebDriver(hub, new FirefoxOptions().setHeadless(headless)));
		}
	}
	
	public static synchronized WebDriver getDriver() {
		return DRIVERS.get();
	}
	
	public static synchronized void removeDriver() {
		DRIVERS.remove();
	}
}