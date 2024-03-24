package com.douglas.nutrisimples.api.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.nutrisimples.domain.User;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "", allowedHeaders = "")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	public ResponseEntity<List<UserDTO>> findall() {
		List<User> list = userService.findAll();
		List<UserDTO> listDto = list.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
	    return ResponseEntity.ok().body(listDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getById(@PathVariable Long id) {
		User object = userService.findById(id);
		return ResponseEntity.ok().body(object);
	}
}
