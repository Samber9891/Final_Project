package com.tts.finalproject.controller;

import java.util.ArrayList;
import java.util.List;

import com.tts.finalproject.model.BlogPost;
import com.tts.finalproject.model.User;
import com.tts.finalproject.repository.BlogPostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class BlogController {

    @Autowired 
    private BlogPostRepository blogPostRepository; 
    public static List<BlogPost> post = new ArrayList<>(); 

    @GetMapping(value="/")
    public String index(BlogPost blogPost, Model model) {
        // allows the index.html page to access the ArrayList
        model.addAttribute("post", post); 
        return "/index";
    }

    @GetMapping(value="/new")
    public String newBlog(BlogPost blogPost) {
        return "/new";
    }

    private BlogPost blogPost; 

    @PostMapping(value = "/")
    public String addNewBlogPost(BlogPost blogPost, Model model) {
        blogPostRepository.save(new BlogPost(blogPost.getTitle(), blogPost.getAuthor(), blogPost.getBlogEntry()));
        post.add(blogPost); 
        model.addAttribute("title", blogPost.getTitle()); 
        model.addAttribute("author", blogPost.getAuthor());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        
        return "result"; 
    }

    private User user; 

    @GetMapping(value = "/admin")
    public String signInAsAdmin(User user) {
        return "admin";
    }
}
