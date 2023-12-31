package com.mdq.springjwt.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdq.springjwt.models.Comment;
import com.mdq.springjwt.services.CommentService;




@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/comment")
public class CommentController {
	private final CommentService commentService;

	@Autowired
	public CommentController(CommentService commentService) {

		this.commentService = commentService;
	}

	    @GetMapping("/")
	    public List<Comment> findAll() {
	        return commentService.findAll();
	    }

	    @PostMapping("/save")
	    public Comment save(@RequestBody Comment entity) {
	        return commentService.save(entity);
	    }

		@GetMapping("/story/{id}")
		public List<Comment> findCommentsByStoryId(@PathVariable Long id){
			return commentService.findCommentsByStoryId(id);
		}


	    @GetMapping("/{id}")
	    public Optional<Comment> findById(@PathVariable Long id) {
	        return commentService.findById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	commentService.deleteById(id);
	    }

	    @PutMapping("/update/{id}")
	    public void update(@RequestBody Comment comment) {
	    	commentService.update(comment);
	    }
}
