package com.tmb.utils;

import com.tmb.pojos.User;

public final class RequestTestDataBuilder {

	private RequestTestDataBuilder() {}

	public static User getUserPayload(User data) {
		return User.builder()
				.setName(data.getName())
				.setJob(data.getJob())
				.build();
	}
}
