package com.tmb.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {}

	private static final String RESOURCESPATH = System.getProperty("user.dir")+"\\src\\test\\resources";
	private static final String CREATEUSERRESPONSESCHEMAFILEPATH = RESOURCESPATH + "\\responsejsonschemas\\user.json";
	private static final String USERTESTDATAJSONFILEPATH = RESOURCESPATH + "\\testdata\\testdata.json";

	public static String getCreateUserResponseSchemaFilePath() {
		return CREATEUSERRESPONSESCHEMAFILEPATH;
	}

	public static String getUserTestDataJsonFilePath() {
		return USERTESTDATAJSONFILEPATH;
	}

	//	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	//	private static final String CREATEUSERRESPONSESCHEMAFILEPATH = RESOURCESPATH + "/responsejsonschemas/user.json";
	//
	//	public static String getCreateUserResponseSchemaFilePath() {
	//		return CREATEUSERRESPONSESCHEMAFILEPATH;
	//	}
}