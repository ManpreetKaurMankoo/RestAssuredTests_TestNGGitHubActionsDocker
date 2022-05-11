package com.tmb.utils;

import com.tmb.pojos.User;

public class RequestTestDataBuilder {

	private RequestTestDataBuilder() {}

	public static User withUserPayload(User data) {

		User user = new User();

		user.setName(data.getName());
		user.setJob(data.getJob());

		return user;
	}

}
