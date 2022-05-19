package com.tmb.constants;

public final class FrameworkConstants {

	private FrameworkConstants() {}

	private static final String RESOURCESPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CREATEUSERRESPONSESCHEMAFILEPATH = RESOURCESPATH + "/responsejsonschemas/user.json";

	public static String getCreateUserResponseSchemaFilePath() {
		return CREATEUSERRESPONSESCHEMAFILEPATH;
	}
}