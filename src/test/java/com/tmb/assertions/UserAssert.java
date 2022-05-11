package com.tmb.assertions;

import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

import com.tmb.pojos.User;

public class UserAssert extends AbstractAssert<UserAssert, User> {

	private UserAssert(User user, Class<?> selfType) {
		super(user, selfType);
	}

	public static UserAssert assertThat(User userParsedResponse) {
		return new UserAssert(userParsedResponse, UserAssert.class);
	}

	public UserAssert hasName(String name) {
		Assertions.assertThat(actual.getName())
			.withFailMessage(() -> "Name does not match")
			.isEqualTo(name);
		return this;
	}

	public UserAssert hasJob(String job) {
		Assertions.assertThat(actual.getJob())
			.withFailMessage(() -> "Job does not match")
			.isEqualTo(job);
		return this;
	}

}
