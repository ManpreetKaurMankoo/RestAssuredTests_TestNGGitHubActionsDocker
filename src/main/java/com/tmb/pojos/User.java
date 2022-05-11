package com.tmb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

	private String name;
	private String job;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String createdAt;

}
