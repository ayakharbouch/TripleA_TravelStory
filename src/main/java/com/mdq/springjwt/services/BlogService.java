package com.mdq.springjwt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mdq.springjwt.models.Blog;
import com.mdq.springjwt.repository.BlogRepository;




@Service
public class BlogService {

	@Autowired
    private BlogRepository blogRepository;
	
	public List<Blog> findAll() {return blogRepository.findAll();}

    public Blog save(Blog entity) {return blogRepository.save(entity);}

    public Optional<Blog> findById(Long id) {return blogRepository.findById(id);}

    public void deleteById(Long id){
    	blogRepository.deleteById(id);
    }
    public void update(Blog blog){
    	blogRepository.save(blog);
    }

}
