package com.tmb.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.sskorol.data.Source;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(setterPrefix = "set")
@Source(path = "testdata.json")
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
