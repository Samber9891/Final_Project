package com.tts.finalproject.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tts.finalproject.model.BlogPost;
import com.tts.finalproject.repository.BlogPostRepository;
import com.tts.finalproject.service.BlogPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BlogController {

    @Autowired
    private BlogPostRepository blogPostRepository;
    
    @Autowired
    BlogPostService blogPostService; 
     
    public List<BlogPost> posts = new ArrayList<>();

    @ModelAttribute("genres")
    public List<String> genres() {
        return blogPostService.findDistinctGenres(); 
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(required = false) String genre, Model model) {
        List<BlogPost> filtered = blogPostService.findByGenre(genre);
        model.addAttribute("posts", filtered); // Overrides the @ModelAttribute above.
        return "index";
    }

    @GetMapping(value="/")
    public String index(BlogPost blogPost, Model model) {
        posts.removeAll(posts); 
        for (BlogPost post : blogPostRepository.findAll()) {
            posts.add(post); 
        }
        model.addAttribute("posts", posts); 
        return "index";
        }
    
    @GetMapping(value = "/blogpost/new")
    public String newBlog(BlogPost blogPost) {
        return "new";
    }

    @GetMapping(value = "/fullblog/{id}")
    public String showBlog(@PathVariable Long id, Model model) {
        Optional<BlogPost> posts =  blogPostRepository.findById(id);
        model.addAttribute("posts", posts);
        System.out.println(posts);
        return "redirect:/fullblog/" + blogPost.getId();
    }
      // end of create new blog


    // goes to result after new blog has been saved in the database

    private BlogPost blogPost;

    @PostMapping(value = "/blogpost")
    public String addNewBlogPost(BlogPost blogPost, Model model) {

        blogPostRepository.save(blogPost); 
        model.addAttribute("title", blogPost.getTitle());
        model.addAttribute("genre", blogPost.getGenre());
        model.addAttribute("blogEntry", blogPost.getBlogEntry());
        model.addAttribute("imageUrl", blogPost.getImageUrl());
        model.addAttribute("youtubeUrl", blogPost.getYoutubeUrl());
        return "result";
    }



    // finds the blog post id, then deletes the specified post
    @RequestMapping(value = "/blogpost/delete/{id}")
    public String deletePostWithId(@PathVariable Long id, BlogPost blogPost) {
        blogPostRepository.deleteById(id);
        return "delete";
            } 
    // end of delete by id

    // finds blog post by id then edits the post, connected to blog.id in thymeleaf html

    @RequestMapping(value = "/blogpost/edit/{id}")
    public String editPostWithId(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            model.addAttribute("blogPost", actualPost);
        }
        return "edit";
    }

    @RequestMapping(value = "/blogpost/update/{id}")
    public String updateExistingPost(@PathVariable Long id, BlogPost blogPost, Model model) {
        Optional<BlogPost> post = blogPostRepository.findById(id);
        if (post.isPresent()) {
            BlogPost actualPost = post.get();
            actualPost.setTitle(blogPost.getTitle());
            actualPost.setGenre(blogPost.getGenre());
            actualPost.setBlogEntry(blogPost.getBlogEntry());
            actualPost.setImageUrl(blogPost.getImageUrl());
            actualPost.setYoutubeUrl(blogPost.getYoutubeUrl());
            blogPostRepository.save(actualPost);
            model.addAttribute("blogPost", actualPost);
        }
 
        return "result";
    }

    // end of update mapping
   
  

   
    }

