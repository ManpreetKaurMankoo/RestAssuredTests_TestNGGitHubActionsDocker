package com.tmb.pojos;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public final class UserResponsePOJO {

	private UserResponsePOJO() {}

	@JsonProperty("name")
	private String name;

	@JsonProperty("job")
	private String job;

}

