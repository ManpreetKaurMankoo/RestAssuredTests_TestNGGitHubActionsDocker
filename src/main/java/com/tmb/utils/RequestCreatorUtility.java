package com.tmb.utils;

import static com.tmb.utils.RequestResponseSpecCreatorUtils.requestSpecification;
import static io.restassured.RestAssured.given;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public final class RequestCreatorUtility {

	private RequestCreatorUtility() {}

	@Step
	public static <T> Response hitPOSTAPI(T data, String endpoint) {

		System.out.println("Inside hitPOSTAPI");

		System.out.println("request: " + given()
		.spec(requestSpecification())
		.body(data)
		.when().log().all().post(endpoint));


		return given()
				.spec(requestSpecification())
				.body(data)
				.when().log().all().post(endpoint);
	}

}
