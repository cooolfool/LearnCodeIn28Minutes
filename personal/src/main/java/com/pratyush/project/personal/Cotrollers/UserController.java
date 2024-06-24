package com.pratyush.project.personal.Cotrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratyush.project.personal.Beans.User;
import com.pratyush.project.personal.DaoService.UserDaoService;
import com.pratyush.project.personal.DaoService.userNotFoundException;

@RestController
public class UserController {
	
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		 return userDaoService.findAll();	
	}
	
	@GetMapping(path = "/users/{id}")
	public Optional<User> retrieveUser(@PathVariable Integer id) {
		Optional<User> user = userDaoService.find(id);
		if(user == null)
			throw new userNotFoundException("User not found with Id : "+ id);
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user ) {
		userDaoService.save(user);
		return ResponseEntity.created(null).build();
	}
	
	

}
