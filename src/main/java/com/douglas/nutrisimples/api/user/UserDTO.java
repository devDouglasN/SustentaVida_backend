package com.douglas.nutrisimples.api.user;

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
}
