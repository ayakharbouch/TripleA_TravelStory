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
public class Story {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long storyId;

	 private String title;

	 private String content;

	 private String image1;

	 private String image2;

	 private String image3;

	 private String city;
	 private String author;




	public Long getStoryId() {
		return storyId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public Story(Long storyId, String title, String content) {
		this.storyId = storyId;
		this.title = title;
		this.content = content;

	}

	public Story() {
	}

	public Story(String title, String content) {
		this.title = title;
		this.content = content;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}

	public Story(Long storyId, String title, String content, String image1, String image2, String image3) {
		this.storyId = storyId;
		this.title = title;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
	}

	public Story(Long storyId, String title, String content, String image1, String image2) {
		this.storyId = storyId;
		this.title = title;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
	}

	public Story(Long storyId, String title, String content, String image1) {
		this.storyId = storyId;
		this.title = title;
		this.content = content;
		this.image1 = image1;
	}

	public Story(Long storyId, String title, String content, String image1, String image2, String image3, String city,
			String author) {
		this.storyId = storyId;
		this.title = title;
		this.content = content;
		this.image1 = image1;
		this.image2 = image2;
		this.image3 = image3;
		this.city = city;
		this.author = author;
	}




}
