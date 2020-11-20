package com.tts.finalproject.repository;


import com.tts.finalproject.model.BlogPost;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {
  
}
