package com.douglas.nutrisimples.domain;

import lombok.Data;

@Data
public class UserLogin {
		
	private Long id;
	private String name;
	private String user;
	private String password;
	private String photograph;
	private String token;
}
