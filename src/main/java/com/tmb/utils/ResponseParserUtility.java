package com.tmb.utils;

import static com.tmb.utils.RequestResponseSpecCreatorUtils.responseSpecification;

import io.restassured.response.Response;

public final class ResponseParserUtility {

	private ResponseParserUtility() {}

	public static <T> T parseResponse(Response response, Class<T> classType) {
		Response extractedResponse = response.then().spec(responseSpecification()).log().all().extract().response();
		return extractedResponse.as(classType);
	}
}
