package com.tmb.assertions;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import io.restassured.response.Response;

public class ResponseAssert extends AbstractAssert<ResponseAssert, Response> {

	private ResponseAssert(Response response, Class<?> selfType) {
		super(response, selfType);
	}

	public static ResponseAssert assertThat(Response response) {
		return new ResponseAssert(response, ResponseAssert.class);
	}

	public ResponseAssert gives201SuccessfulPostResponse() {
		Assertions.assertThat(actual.getStatusCode())
		.withFailMessage(() -> "Status code is not 201")
		.isEqualTo(201);
		return this;
	}

	public ResponseAssert hasExpectedResponseJsonSchema() {
		actual.then().assertThat()
		.body(matchesJsonSchema(new File("src/test/resources/responsejsonschemas/user.json"))); // abstract out the path as constant
		return this;
	}

	public ResponseAssert hasResponseTimeWithinTwoSecs() {
		Assertions.assertThat(actual.getTimeIn(TimeUnit.SECONDS))
		.withFailMessage(() -> "Response time is not within 2 seconds")
		.isLessThanOrEqualTo(2000);
		return this;
	}

	public ResponseAssert containsHeaderApplicationJson() {
		Assertions.assertThat(actual.header("Content-Type"))
		.withFailMessage(() -> "Response does not contain Header with Content-Type as application/json")
		.contains("application/json");
		return this;
	}
}

