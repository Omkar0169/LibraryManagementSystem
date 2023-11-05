package com.spring.test.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequest {

	private String username;
	private String email;
	private String password;
	private int roleId;
	private String confirmpassword; 

}
