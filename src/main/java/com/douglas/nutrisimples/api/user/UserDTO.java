package com.douglas.nutrisimples.api.user;

import com.douglas.nutrisimples.domain.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Long id;

	@NotBlank(message = "User name is required!")
	@Size(min = 3, max = 90)
	private String name;

	@NotBlank(message = "Email is required!")
	@Size(min = 6, max = 50)
	private String email;

	private String password;

	public UserDTO (User user) {
			this.id = user.getId();
			this.name = user.getName();
			this.email = user.getEmail();
			this.password = user.getPassword();
		}
}
