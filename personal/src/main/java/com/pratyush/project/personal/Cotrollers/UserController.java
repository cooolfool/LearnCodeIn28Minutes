package com.pratyush.project.personal.Cotrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratyush.project.personal.Beans.User;
import com.pratyush.project.personal.DaoService.UserDaoService;
import com.pratyush.project.personal.Exceptions.userNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	UserDaoService userDaoService;
	
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		 return userDaoService.findAll();	
	}
	
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable Integer id) {
		User user = userDaoService.find(id);
		if(user == null)
			throw new userNotFoundException("User not found with Id : "+ id);
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user ) {
		userDaoService.save(user);
		return ResponseEntity.created(null).build();
	}
	
	
	@DeleteMapping(path = "/deleteUsers/{id}")
	public void deleteUser(@PathVariable Integer id) {
		 userDaoService.delete(id);
	}
	
	

}
