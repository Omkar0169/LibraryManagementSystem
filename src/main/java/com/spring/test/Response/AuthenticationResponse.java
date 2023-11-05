package com.spring.test.Response;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AuthenticationResponse {

	private String token;
	private String type = "Bearer";
	private Integer id;
	private String email;
	private String username;
	private List<String> roles;
	
	
	public AuthenticationResponse() {}

	public AuthenticationResponse(String token, String type, Integer id, String username, String email, List<String> roles) {
		this.token = token;
		this.type = type;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
	}
}
