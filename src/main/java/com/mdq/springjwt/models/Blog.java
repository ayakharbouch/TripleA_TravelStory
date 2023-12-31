package com.mdq.springjwt.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Blog {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long blogId;
	 

	 @ManyToOne
	 @JoinColumn(name = "story_id")
	 private Story story; 
	 

	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private User user;

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Blog(Long blogId,Story story,User user) {
		this.blogId = blogId;
		this.story = story;
		this.user = user;
	}

	public Blog() {
	} 
	 
	 
}
