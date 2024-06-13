package com.douglas.nutrisimples.api.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDTO(
		Long id,
		@NotBlank(message = "User name is required!") @Size(min = 3, max = 90) String name,
		@NotBlank(message = "Email is required!") @Size(min = 6, max = 50) String email,
		String password
) {}
