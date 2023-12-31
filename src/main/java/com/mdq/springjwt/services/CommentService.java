package com.mdq.springjwt.services;

import java.io.Console;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdq.springjwt.models.Comment;
import com.mdq.springjwt.models.Story;
import com.mdq.springjwt.repository.CommentRepository;
import com.mdq.springjwt.repository.StoryRepository;




@Service
public class CommentService {

	@Autowired
    private CommentRepository commentRepository;
    private StoryService storyService;

	public List<Comment> findAll() {return commentRepository.findAll();}

    public Comment save(Comment entity) {return commentRepository.save(entity);}

    public Optional<Comment> findById(Long id) {return commentRepository.findById(id);}

    public void deleteById(Long id){
    	commentRepository.deleteById(id);
    }
    public void update(Comment comment){
    	commentRepository.save(comment);
    }

    private final StoryRepository storyRepository;



    public List<Comment> findCommentsByStoryId(Long id) {
        Optional<Story> storyOptional = storyService.findById(id);

        if (storyOptional.isPresent()) {
            Story story = storyOptional.get();
            List<Comment> comments = commentRepository.findByStory(story);
            return comments;
        } else {

            return List.of();
        }
    }



   
    public CommentService(CommentRepository commentRepository, StoryRepository storyRepository) {
        this.commentRepository = commentRepository;
        this.storyRepository = storyRepository;
    }

    
}
