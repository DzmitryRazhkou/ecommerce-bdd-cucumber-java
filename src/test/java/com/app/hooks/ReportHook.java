package com.app.hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.app.utils.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

/**
 * Cette classe sert de "hook" pour le rapport. 
 * @author Muana Kimba
 */
public class ReportHook {
	
	@After(order=1)
	public void afterScenario_Screenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			// prendre photo
			String screenshotName = scenario.getName().replace(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}