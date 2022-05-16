package com.tmb.utils;

import com.tmb.pojos.User;

public class RequestTestDataBuilder {

	private RequestTestDataBuilder() {}

	public static User getUserPayload(User data) {

		return User.builder()
				.setName(data.getName())
				.setJob(data.getJob())
				.build();

		//		User user = new User();
		//
		//		user.setName(data.getName());
		//		user.setJob(data.getJob());
		//
		//		return user;
	}

}
