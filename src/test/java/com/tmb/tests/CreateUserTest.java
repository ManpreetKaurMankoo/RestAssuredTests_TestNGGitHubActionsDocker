package com.tmb.tests;

import static com.tmb.assertions.ResponseAssert.assertThat;
import static com.tmb.assertions.UserAssert.assertThat;
import static com.tmb.constants.StringEndpoints.getUserEndpoint;
import static com.tmb.utils.RequestCreatorUtility.hitPOSTAPI;
import static com.tmb.utils.RequestTestDataBuilder.getUserPayload;
import static com.tmb.utils.ResponseParserUtility.parseResponse;
import static io.github.sskorol.data.TestDataReader.use;

import org.testng.annotations.Test;

import com.tmb.pojos.User;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import io.restassured.response.Response;
import one.util.streamex.StreamEx;

public final class CreateUserTest {

	@Test(dataProvider = "getData")
	public void createUserTest(User data) {

		Response response = hitPOSTAPI(getUserPayload(data), getUserEndpoint());
		User userParsedResponse = parseResponse(response, User.class);

		assertThat(response)
				.gives201SuccessfulPostResponse()
				.hasExpectedResponseJsonSchema()
				.hasResponseTimeWithinTwoSecs()
				.containsHeaderApplicationJson();

		assertThat(userParsedResponse)
				.hasName(data.getName())
				.hasJob(data.getJob());
	}

	@DataSupplier
//	public StreamEx<User> getData() {
//		return use(JsonReader.class)
//				.withTarget(User.class)
////				.withSource("\\src\\test\\resources\\testdata\\testdata.json")
//				.withSource(getUserTestDataJsonFilePath())
//				.read();
//	}
	public StreamEx<User> getData() {
		return use(JsonReader.class)
				.withTarget(User.class)
				.withSource("testdata/testdata.json")
				.read();
	}
}
