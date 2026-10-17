package com.bharath.learning.socialmediablog.social_media_blog_app.controller;

import com.bharath.learning.socialmediablog.social_media_blog_app.payLoad.PostResponse;
import com.bharath.learning.socialmediablog.social_media_blog_app.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/api/posts")
public class PostController2 {
@Autowired
    private PostService postService;
@GetMapping
    public PostResponse fetchAllPosts(@RequestParam(value="pageNo",defaultValue="0",required=false) int pageNo,
                                      @RequestParam(value="pageSize",defaultValue="0",required = false) int pageSize){
    return this.postService.getAllPosts(pageNo,pageSize);
}
}
