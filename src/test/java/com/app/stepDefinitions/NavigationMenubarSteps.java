package com.app.stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.text.WordUtils;
import org.openqa.selenium.WebElement;

import com.app.constants.FilePaths;
import com.app.context.TestContext;
import com.app.pageObjects.DashboardPage;
import com.app.utils.DataReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;

public class NavigationMenubarSteps {

	// VARIABLES D'INSTATNCE
	private DashboardPage dashboardPage;
	private String menu;	// seule la première lettre est en majuscule pour servir de paramètre aux méthodes de DashboardPage

	// INJECTION AVEC PicoContainer
	public NavigationMenubarSteps(TestContext testContext) {
		dashboardPage = testContext.getDashboardPage();
	}
	
	// ÉTAPES
	@Alors("^les menus de navigation suivants doivent être affichés:$")
	public void les_menus_de_navigation_suivants_doivent_être_affichés(DataTable menus) {
		menus.asList()
		.stream()
		// parcourir la liste de menus
		// et mettre en majuscule la première lettre du menu et vérifier s'il est affiché
		.forEach(menu -> assertTrue(dashboardPage.adminNavigation.isMenuDisplayed(WordUtils.capitalizeFully(menu))));
	}
	
	@Quand("^je clique sur le menu de navigation \"([^\"]+)\"$")
	public void je_clique_sur_le_menu_de_navigation(String menu) {
		this.menu = WordUtils.capitalizeFully(menu);	// garder la valeur du menu pour l'autre étape du scénario
		dashboardPage.adminNavigation.clickMenu(this.menu);
	}
	
	@Alors("^ses sous-menus, compris dans le fichier \"([^\"]+.json)\", doivent s'afficher sous le\\(s\\) titre\\(s\\) \"([A-Z]{1}[^\"]+)\"$")
	public void ses_sous_menus_compris_dans_le_fichier_doivent_s_afficher_sous_le_s_titre_s(String fichierJSON, String titre_sous_menu) {
		Map<String, List<String>> sousMenus_attendus = DataReader.getListFromJSONKey(FilePaths.TEST_DATA + fichierJSON, menu.toUpperCase());
		List<String> titres = Arrays.asList(titre_sous_menu.split(", "));
		
		titres
		.stream()
		.forEach(titre -> assertEquals("Échec: Les sous-menus obtenus du titre " + titre + " ne sont pas égaux aux sous-menus attendus!",
				sousMenus_attendus.get(titre), dashboardPage.adminNavigation.getTitleSubMenus(menu, titre).stream().map(WebElement::getText).collect(Collectors.toList()))
				);
	}
}