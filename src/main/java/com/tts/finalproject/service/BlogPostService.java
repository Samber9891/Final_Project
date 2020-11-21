package com.tts.finalproject.service;

import java.util.List;


import com.tts.finalproject.model.BlogPost;
import com.tts.finalproject.repository.BlogPostRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class BlogPostService {
    
    @Autowired BlogPostRepository blogPostRepository; 


    public List<BlogPost> findAll() {
        return blogPostRepository.findAll();
    }


    public BlogPost findById(long id) {
        return blogPostRepository.findById(id); 
    }

   
	public List<String> findDistinctGenres() {
		return blogPostRepository.findDistinctGenres();
	}


    public List<BlogPost> findByGenre(String genre) {
        
        if (genre != null)
            return blogPostRepository.findByGenre(genre);
        else 
            return blogPostRepository.findAll();
       
       
       
        }


	
    }
