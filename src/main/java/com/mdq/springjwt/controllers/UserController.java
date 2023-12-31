package com.mdq.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mdq.springjwt.models.User;
import com.mdq.springjwt.services.UserService;




@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/user")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	    @GetMapping("/")
	    public List<User> findAll() {
	        return userService.findAll();
	    }

	    @PostMapping("/save")
	    public User save(@RequestBody User entity) {
	        return userService.save(entity);
	    }

	    @GetMapping("/{id}")
	    public Optional<User> findById(@PathVariable Long id) {
	        return userService.findById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	userService.deleteById(id);
	    }

	    @PutMapping("/update/{id}")
	    public void update(@RequestBody User user) {
	    	userService.update(user);
	    }
	    
	   

}
