package com.tmb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(setterPrefix = "set")
@NoArgsConstructor
@AllArgsConstructor
public class User {

	private String name;
	private String job;

	@JsonIgnore
	private String id;

	@JsonIgnore
	private String createdAt;

}
