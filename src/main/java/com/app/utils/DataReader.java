package com.app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Cette classe contient des méthodes utilitaires pour lire les fichiers
 * .properties et .csv.
 * @author Muana Kimba
 */
public final class DataReader {

	// CONSTRUCTEUR
	private DataReader() throws Exception {
		throw new Exception();
	}

	// MÉTHODES
	/**
	 * Cette méthode lit un fichier .properties pour la configuration.
	 * @param filename Le nom du fichier .properties à lire
	 * @return Un objet de la classe Properties
	 */
	public static Properties readConfig(String filename) {
		Properties properties = null;

		try {
			properties = new Properties();
			FileInputStream fis = new FileInputStream(filename);
			properties.load(fis);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}

		return properties;
	}

	/**
	 * Cette méthode lit un fichier .json et retourne une liste correspondant à la clé reçu en paramètre.
	 * @param filename Le nom du fichier .json à lire
	 * @param key La clé
	 * @return Une liste de valeurs
	 */
	public static Map<String, List<String>> getListFromJSONKey(String filename, String key) {
		Map<String, List<String>> testdata = null;
		
		// analyseur de fichier JSON
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(filename))	// lire de fichier JSON
		{
			// traduire le fichier JSON
			Object object = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) object;

			// récupérer l'objet JSON qui est un dictionnaire de listes
			testdata = (Map<String, List<String>>) jsonObject.get(key);
		} catch(FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		} catch(ParseException pe) {
			pe.printStackTrace();
		}
		
		return testdata;
	}
}