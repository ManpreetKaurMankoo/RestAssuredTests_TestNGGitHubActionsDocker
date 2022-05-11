package com.tmb.tests;

import static com.tmb.constants.StringEndpoints.withUserEndpoint;
import static com.tmb.utils.RequestCreatorUtility.hitPOSTAPI;
import static com.tmb.utils.RequestTestDataBuilder.withUserPayload;
import static com.tmb.utils.ResponseParserUtility.parseResponse;
import static io.github.sskorol.data.TestDataReader.use;
import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.tmb.pojos.User;

import io.github.sskorol.core.DataSupplier;
import io.github.sskorol.data.JsonReader;
import io.restassured.response.Response;
import one.util.streamex.StreamEx;

public final class CreateUserTest {

	@Test(dataProvider = "getData")
	public void createUserTest(User data) {

		System.out.println("Inside test");

		Response response = hitPOSTAPI(withUserPayload(data), withUserEndpoint());
		System.out.println("response: " + response);
		User parsedResponse = parseResponse(response, User.class);
		System.out.println("Parsed res: " + parsedResponse);


		assertThat(response.getStatusCode()).isEqualTo(201);
		assertThat(parsedResponse.getName()).isEqualTo("expectedName");
		assertThat(parsedResponse.getJob()).isEqualTo("expectedJob");
		//response code, response schema, response time within 2 secs, response header, response can be deserialized to POJO
	}

	@DataSupplier
	public StreamEx<User> getData() {
		return use(JsonReader.class)
				.withTarget(User.class)
				.withSource("testdata/testdata.json")
				.read();
	}

	//	@DataSupplier
	//	public Object[][] getData() {
	//		return new Object[][] {{"Name1", "Job1"}, {"Name2", "Job2"}};
	//	}

}
