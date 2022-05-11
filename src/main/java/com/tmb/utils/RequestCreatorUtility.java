package com.tmb.utils;

import static com.tmb.utils.RequestResponseSpecCreatorUtils.requestSpecification;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public final class RequestCreatorUtility {

	private RequestCreatorUtility() {}

	@Step
	public static <T> Response hitPOSTAPI(T data, String endpoint) {
		return given()
				.spec(requestSpecification())
				.body(data)
				.when().log().all().post(endpoint);
	}

}
