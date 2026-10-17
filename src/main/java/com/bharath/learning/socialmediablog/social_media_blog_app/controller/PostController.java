package com.bharath.learning.socialmediablog.social_media_blog_app.controller;

import com.bharath.learning.socialmediablog.social_media_blog_app.dto.PostDto;
import com.bharath.learning.socialmediablog.social_media_blog_app.model.PostEntity;
import com.bharath.learning.socialmediablog.social_media_blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/posts")
public class PostController {
    @Autowired
    private PostService postService;
    //Get all posts
    @GetMapping
    public List<PostDto>fetchAllPost(){
        return this.postService.getAllPost();
    }
    //Get post By id
    @GetMapping("/{id}")
    public PostDto getById(@PathVariable long id){
        return this.postService.getPostById(id);
    }
    @PostMapping
    public PostDto createSavePost(@RequestBody PostDto postdto){
        return this.postService.createPost(postdto);
    }
    @PutMapping("/{id}")
    public PostDto updatesavePost(@RequestBody PostDto postDto,@PathVariable long id){
        return this.postService.updatePost(postDto,id);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePost(@PathVariable long id){
        boolean isDeleted = this.postService.deletePostById(id);
        if(isDeleted){
           return ResponseEntity.ok("Post "+id+" delete successfully");
        }else
            return new ResponseEntity<>("Error while deleting Post "+id, HttpStatus.NOT_FOUND);
    }
}
