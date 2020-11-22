package com.tts.finalproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BlogPost{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; 

    private String title; 

    private String genre; 
   
    private String imageUrl;
   
    private String blogEntry;

    private String youtubeUrl; 

    public BlogPost() {
    }

    public BlogPost(String title, String genre, String imageUrl, String blogEntry, String youtubeUrl) {
        this.title = title;
        this.genre = genre;
        this.imageUrl = imageUrl;
        this.blogEntry = blogEntry;
        this.youtubeUrl = youtubeUrl;
    }

    public Long getId() {
        return id;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBlogEntry() {
        return blogEntry;
    }

    public void setBlogEntry(String blogEntry) {
        this.blogEntry = blogEntry;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    @Override
    public String toString() {
        return "BlogPost [blogEntry=" + blogEntry + ", genre=" + genre + ", id=" + id + ", imageUrl=" + imageUrl
                + ", title=" + title + ", youtubeUrl=" + youtubeUrl + "]";
    }

    

    
    


}
       