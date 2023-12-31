package com.mdq.springjwt.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Comment {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long commentId;
	 
	 private String text;
	 private String commentator;


	 @ManyToOne
	 @JoinColumn(name = "story_id")
	 private Story story;


	public String getCommentator() {
		return commentator;
	}

	public void setCommentator(String commentator) {
		this.commentator = commentator;
	}

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	
	public Comment(Long commentId, String text,Story story) {
		this.commentId = commentId;
		this.text = text;
		this.story = story;
	}

	public Comment(Long commentId, String text) {
		this.commentId = commentId;
		this.text = text;
	}

	public Comment() {
	}

	public Comment(String text, Story story) {
		this.text = text;
		this.story = story;
	}

	public Comment(Long commentId, String text, String commentator, Story story) {
		this.commentId = commentId;
		this.text = text;
		this.commentator = commentator;
		this.story = story;
	}
	 
	 
	 
}
