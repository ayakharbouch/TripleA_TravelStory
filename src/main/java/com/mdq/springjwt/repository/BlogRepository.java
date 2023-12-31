package com.mdq.springjwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdq.springjwt.models.Blog;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long>{

}
