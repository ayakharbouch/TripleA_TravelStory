package com.mdq.springjwt.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mdq.springjwt.models.Story;
import com.mdq.springjwt.services.StoryService;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;



@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/api/story")
public class StoryController {

	private final StoryService storyService;

	@Autowired
	public StoryController(StoryService storyService) {
		this.storyService = storyService;
	}

	@GetMapping("/")
	    public List<Story> findAll() {
	        return storyService.findAll();
	    }

	    @PostMapping("/save")
	    public Story save(@RequestParam("title") String title,
	                      @RequestParam("content") String content,
	                      @RequestParam("image1") MultipartFile image1,
	                      @RequestParam("image2") MultipartFile image2,
	                      @RequestParam("image3") MultipartFile image3) {
	        // Process and save the files and other data here

	        Story story = new Story();
	        story.setTitle(title);
	        story.setContent(content);

	        // Save images to the desired location
	        story.setImage1(saveImage(image1));
	        story.setImage2(saveImage(image2));
	        story.setImage3(saveImage(image3));

	        // Set other properties as needed

	        // Save the story entity to the database
	        return storyService.save(story);
	    }

	    // Function to save an uploaded image to a specific directory with a random name
	    private String saveImage(MultipartFile file) {
	        if (!file.isEmpty()) {
	            try {
	                // Generate a random image name using UUID
	                String imageName = UUID.randomUUID().toString() + ".jpg";
	                byte[] bytes = file.getBytes();
	                Path path = Paths.get("/Users/ouatilanas/Downloads/VF/paper-dashboard-react-main copy - Copy copy/src/assets/img/" + imageName);
	                Files.write(path, bytes);
	                return imageName;
	            } catch (IOException e) {
	                e.printStackTrace();
	                // Handle the exception (e.g., logging or throwing custom exception)
	            }
	        }
	        return null;
	    }
	    
	    @GetMapping("/author/{author}")
		public List<Story> findStoriesByAuthor(@PathVariable String author) {
			return storyService.findStoriesByAuthor(author);
		}
	    
	    @GetMapping("/{id}")
	    public Optional<Story> findById(@PathVariable Long id) {
	        return storyService.findById(id);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteById(@PathVariable Long id) {
	    	storyService.deleteById(id);
	    }

	    @PutMapping("/update/{id}")
	    public void update(@RequestBody Story story) {
	    	storyService.update(story);
	    }
}
