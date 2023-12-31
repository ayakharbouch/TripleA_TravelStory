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

import com.mdq.springjwt.models.Blog;
import com.mdq.springjwt.services.BlogService;



@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/blog")
public class BlogController {

	private final BlogService blogService;
	@Autowired
	public BlogController(BlogService blogService) {
		this.blogService = blogService;
	}
	    @GetMapping("/")
	    public List<Blog> findAll() {
	        return blogService.findAll();
	    }

	    @PostMapping("/save")
	    public Blog save(@RequestBody Blog entity) {
	        return blogService.save(entity);
	    }

	    @GetMapping("/{id}")
	    public Optional<Blog> findById(@PathVariable Long id) {
	        return blogService.findById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	blogService.deleteById(id);
	    }

	    @PutMapping("/update/{id}")
	    public void update(@RequestBody Blog blog) {
	    	blogService.update(blog);
	    }
}
