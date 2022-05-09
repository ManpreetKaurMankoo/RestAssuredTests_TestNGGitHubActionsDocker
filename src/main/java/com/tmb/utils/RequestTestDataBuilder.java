package com.tmb.utils;

import com.tmb.pojos.UserRequestPOJO;

public class RequestTestDataBuilder {

	private RequestTestDataBuilder() {}

	public static UserRequestPOJO withUserPayload(UserRequestPOJO data) {

		UserRequestPOJO user = new UserRequestPOJO();

		user.setName(data.getName());
		user.setJob(data.getJob());

		return user;
	}

}
