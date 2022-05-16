package com.tmb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(setterPrefix = "set")
public class User {

	private String name;
	private String job;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String createdAt;

}
