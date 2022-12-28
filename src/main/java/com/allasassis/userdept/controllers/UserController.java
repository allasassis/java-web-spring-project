package com.allasassis.userdept.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allasassis.userdept.entities.User;
import com.allasassis.userdept.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserRepository repository;
	
	@GetMapping
	public List<User> findAll() {
		List<User> list = repository.findAll();
		return list;
	}
	
	@GetMapping(value = "/{id}")
	public User findById(@PathVariable Long id) {
		User user = repository.findById(id).get();
		return user;
	}
	
	@PostMapping
	public User insert(@RequestBody User user) {
		User result = repository.save(user);
		return result;
	}
}
