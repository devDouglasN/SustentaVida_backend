package com.douglas.nutrisimples.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do usuário é obrigatório!")
	@Size(min = 3, max = 90)
	private String name;

	@Size(min = 6, max = 50)
	private String email;

	@NotBlank(message = "A senha é obrigatório!")
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();

	public User(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

}
