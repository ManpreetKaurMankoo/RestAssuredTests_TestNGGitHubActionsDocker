package com.tmb.utils;

import static com.tmb.utils.FrameworkConfigFactory.createConfigFactory;

import java.util.Optional;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class RequestResponseSpecCreatorUtils {

	private RequestResponseSpecCreatorUtils() {}

	private static RequestSpecification request;
	private static ResponseSpecification response;

	public static RequestSpecification requestSpecification() {

		//		System.out.println("Inside requestSpecification");

		// Remove unwanted things, return directly, try to make use of optional

		return Optional.ofNullable(request)
				.orElse(new RequestSpecBuilder()
						.setBaseUri(createConfigFactory().baseURI())
						.addHeader("Content-Type", createConfigFactory().contentType())
						.addFilter(new AllureRestAssured())
						.build());

		//		if(Objects.nonNull(request)) {
		//
		//			request = new RequestSpecBuilder()
		//					.setBaseUri(createConfigFactory().baseURI())
		//					.addHeader("Content-Type", createConfigFactory().contentType())
		//					.addFilter(new AllureRestAssured())
		//					.build();
		//
		//			//			System.out.println("Request: " + request);
		//
		//			return request;
		//		}
		//		return request;
	}

	public static ResponseSpecification responseSpecification() {

		return Optional.ofNullable(response)
				.orElse(new ResponseSpecBuilder()
						.expectContentType(ContentType.JSON)
						.build());


		//		if(Objects.nonNull(response)) {
		//
		//			response = new ResponseSpecBuilder()
		//					.expectContentType(ContentType.JSON)
		//					.build();
		//
		//			return response;
		//		}
		//		return response;
	}


}
