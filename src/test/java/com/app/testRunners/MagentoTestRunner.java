package com.app.testRunners;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.app.constants.FilePaths;
import com.app.hooks.AppHook;
import com.app.utils.DataReader;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Cette méthode sert à configurer les options de Cucumber
 * et ensuite à exécuter les scénarios.
 * @author Muana Kimba
 */
@RunWith(Cucumber.class)
@CucumberOptions(
		// le chemin du dossier contenant le/les fichiers .feature OU juste le nom du/des fichiers .feature
		features = {FilePaths.FEATURES},
				//"src/test/resources/com/app/features/SignIn.feature"},
		
		// le nom du dossier contenant le/les fichiers .java de définition d'étapes de scénario
		glue = {FilePaths.STEP_DEFINITIONS, FilePaths.HOOKS},
		//tags = "",
		
		plugin = {"pretty",										// formattage des résultats de test sur la console
				"json:" + FilePaths.CUCUMBER_REPORTS + "report.json",	// rapport json par défault
				"junit:" + FilePaths.CUCUMBER_REPORTS + "report.xml",	// rapport xml de junit
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},	// rapport de ExtentReports
		
		monochrome = true,			// pour ne pas afficher les caractères non-supportés sur la console
		dryRun = false				// pour voir les étapes de scénario qui ne sont pas liées à leur étape de définition
		//publish = true			// gérer dans le fichier src/test/resources/cucumber.properties
		)

public class MagentoTestRunner {
	
	@BeforeClass
    public static void beforeAllFeatures() {
		System.out.println("Début de l'exécuteur de tests!");
		
        AppHook.properties = DataReader.readConfig(FilePaths.TEST_RESOURCES + "test-config.properties");
    }

    @AfterClass
    public static void afterAllFeatures() {
        System.out.println("Fin de l'exécuteur de tests!");
    }
}