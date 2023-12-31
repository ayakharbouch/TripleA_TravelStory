package com.mdq.springjwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdq.springjwt.models.Story;
import com.mdq.springjwt.repository.StoryRepository;





@Service
public class StoryService {
    private final StoryRepository storyRepository;

    @Autowired
    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }
	
	public List<Story> findAll() {return storyRepository.findAll();}

    public Story save(Story entity) {return storyRepository.save(entity);}

    public Optional<Story> findById(Long id) {return storyRepository.findById(id);}

    public void deleteById(Long id){
    	storyRepository.deleteById(id);
    }
    public void update(Story story){
    	storyRepository.save(story);
    }
    public List<Story> findStoriesByAuthor(String author){
        return storyRepository.findStoriesByAuthor(author);
     };
}
