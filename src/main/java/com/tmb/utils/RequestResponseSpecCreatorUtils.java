package com.tmb.utils;

import static com.tmb.utils.FrameworkConfigFactory.createConfigFactory;

import java.util.Optional;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class RequestResponseSpecCreatorUtils {

	private RequestResponseSpecCreatorUtils() {}

	private static RequestSpecification request;
	private static ResponseSpecification response;

	public static RequestSpecification requestSpecification() {
		return Optional.ofNullable(request)
				.orElse(buildRequestSpecification());
	}

	private static RequestSpecification buildRequestSpecification() {
		return new RequestSpecBuilder()
				.setBaseUri(createConfigFactory().baseURI())
				.addHeader("Content-Type", createConfigFactory().contentType())
				.addFilter(new RequestLoggingFilter())
				.build();
	}

	public static ResponseSpecification responseSpecification() {
		return Optional.ofNullable(response)
				.orElse(buildResponseSpecification());
	}

	private static ResponseSpecification buildResponseSpecification() {
		return new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
	}
}
