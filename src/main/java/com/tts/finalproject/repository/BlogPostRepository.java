package com.tts.finalproject.repository;

import java.util.List;

import com.tts.finalproject.model.BlogPost;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {


    List<BlogPost> findAll();

    BlogPost findById(long id);
    List<BlogPost> findByGenre(String genre);

    @Query("SELECT DISTINCT blogPost.genre FROM BlogPost blogPost")
    List<String> findDistinctGenres();
	
}
