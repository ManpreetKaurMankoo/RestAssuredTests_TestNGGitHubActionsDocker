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

		System.out.println("Actual response: " + actual.getBody().asString());
		//		System.out.println("Expected response Schema: " + actual.getBody().asString().matchesJsonSchemaInClasspath("/src/test/resources/responsejsonschemas/user.json").toString());

		//		JsonSchemaValidator s = matchesJsonSchemaInClasspath("user.json");
		//		System.out.println("Schema validator: " + matchesJsonSchemaInClasspath("user.json"));
		//		System.out.println("Schema: " + s.toString());
		//		System.out.println("Output: " + actual.then().assertThat()
		//				.body(matchesJsonSchema(new File("user.json"))).toString());
		//		Assertions.assertThat(actual.then().spec(responseSpecification())
		//				.body(matchesJsonSchema(new File("user.json"))));

		//		Assertions.assertThat(actual.getBody().asString())
		//		.matches((new File("user.json")).toString());

		actual.then().assertThat()
		.body(matchesJsonSchema(new File("src/test/resources/jsonschemas/user.json")));
		//		.isEqualTo(matchesJsonSchema(new File("user.json")).toString());
		//		.withFailMessage(() -> "Response schema does not match")
		//		.matches(matchesJsonSchema(new File("user.json")));
		return this;

		//		Assertions.assertThat(actual.body(matchesJsonSchema(new File("user.json"))).toString())
		//		.withFailMessage(() -> "Response schema does not match")
		//		.isEqualTo(matchesJsonSchemaInClasspath("user.json"));
		//		return this;

		//		Assertions.assertThat(actual.then().assertThat()
		//				.body(matchesJsonSchema(new File("user.json"))));
		//		//		.withFailMessage(() -> "Response schema does not match")
		//		//		.matches(matchesJsonSchema(new File("user.json")));
		//		return this;
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

