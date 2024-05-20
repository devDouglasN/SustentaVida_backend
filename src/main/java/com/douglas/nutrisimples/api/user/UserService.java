package com.douglas.nutrisimples.api.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.nutrisimples.domain.User;
import com.douglas.nutrisimples.repositories.UserRepository;
import com.douglas.nutrisimples.security.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class UserService {

	@Autowired
	public UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Id object: " + id + " not found"));
	}
	
	public User update(Long id, @Valid UserDTO objDTO) {
		objDTO.setId(id);
		User oldObj = findById(id);
		oldObj = new User(objDTO);
		return userRepository.save(oldObj);	
	}
	
	public User create(UserDTO objDTO) {
		objDTO.setId(null);
		User newObj = new User(objDTO);
		return userRepository.save(newObj);
	}

}
