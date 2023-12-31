package com.mdq.springjwt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdq.springjwt.models.Story;


@Repository
public interface StoryRepository extends JpaRepository<Story, Long>{
    List<Story> findStoriesByAuthor(String author);

}
