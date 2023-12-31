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

import com.mdq.springjwt.models.Photo;
import com.mdq.springjwt.services.PhotoService;



@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/photo")
public class PhotoController {

	private final PhotoService photoService;

	@Autowired
	public PhotoController(PhotoService photoService) {
		this.photoService = photoService;
	}

	    @GetMapping("/")
	    public List<Photo> findAll() {
	        return photoService.findAll();
	    }

	    @PostMapping("/save")
	    public Photo save(@RequestBody Photo entity) {
	        return photoService.save(entity);
	    }

	    @GetMapping("/{id}")
	    public Optional<Photo> findById(@PathVariable Long id) {
	        return photoService.findById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	photoService.deleteById(id);
	    }

	    @PutMapping("/update/{id}")
	    public void update(@RequestBody Photo photo) {
	    	photoService.update(photo);
	    }
}
