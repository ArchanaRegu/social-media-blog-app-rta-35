package com.bharath.learning.socialmediablog.social_media_blog_app.service;

import com.bharath.learning.socialmediablog.social_media_blog_app.dto.PostDto;
import com.bharath.learning.socialmediablog.social_media_blog_app.model.PostEntity;
import com.bharath.learning.socialmediablog.social_media_blog_app.payLoad.PostResponse;
import com.bharath.learning.socialmediablog.social_media_blog_app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface PostService {
    //    Get all the Post
    PostResponse getAllPosts(int pageNo,int pageSize);
    PostResponse getAllPosts(int pageNo,int pageSize,String sortBy,String sortDirection);
    List<PostDto>fetchAllPost();
//    Get Post By Id
    PostDto getPostById(long id);
    //    Create Post
    PostDto createPost(PostDto postDtoToBeCreated);

//    Update Post
    PostDto updatePost(PostDto postDto,long postId);
    //Delete Post
boolean deletePostById(long postIdToBeDeleted);
}
