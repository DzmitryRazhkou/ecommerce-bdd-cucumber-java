package com.app.constants;

/**
 * Cette classe contient les chemins de fichiers (configuration, reports, test data et autres).
 * @author Muana Kimba
 */
public final class FilePaths {

	// CONSTRUCTEUR
	private FilePaths() throws Exception {
		throw new Exception();
	}

	// CHEMINS
	public static final String TEST_RESOURCES = "src/test/resources/";
	public static final String FEATURES = TEST_RESOURCES + "com/app/features/";
	public static final String HOOKS = "com/app/hooks";
	public static final String CUCUMBER_REPORTS = "test-output/cucumber-reports/";
	public static final String STEP_DEFINITIONS = "com/app/stepDefinitions";
	public static final String TEST_DATA = TEST_RESOURCES + "com/app/testdata/";
	public static final String EDGE_BINARY = "";
}