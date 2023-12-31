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
public class Photo {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long photoId;
	  
	  private String image;
	  
	  private String description;


	  @ManyToOne
	  @JoinColumn(name = "story_id")
	  private Story story;

	  
	public Long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Story getStory() {
		return story;
	}

	public void setStory(Story story) {
		this.story = story;
	}

	public Photo(Long photoId, String image, String description,Story story) {
		this.photoId = photoId;
		this.image = image;
		this.description = description;
		this.story = story;
	}

	public Photo(Long photoId, String image, String description) {
		this.photoId = photoId;
		this.image = image;
		this.description = description;
	}

	public Photo() {
	}

	
	  
	  
	
}
