package com.bharath.learning.socialmediablog.social_media_blog_app.service.impl;

import com.bharath.learning.socialmediablog.social_media_blog_app.dto.PostDto;
import com.bharath.learning.socialmediablog.social_media_blog_app.exceptions.ResourceNotFoundException;
import com.bharath.learning.socialmediablog.social_media_blog_app.model.PostEntity;
import com.bharath.learning.socialmediablog.social_media_blog_app.repository.PostRepository;
import com.bharath.learning.socialmediablog.social_media_blog_app.service.PostService;
import com.bharath.learning.socialmediablog.social_media_blog_app.util.PostEntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private static final Logger LOGGER= LoggerFactory.getLogger(PostServiceImpl.class);
    @Autowired
private PostRepository postRepository;
    @Autowired
    private PostEntityMapper postEntityMapper;
        @Override
    public List<PostDto> getAllPost() {

        List<PostEntity>postEntities = postRepository.findAll();
        if(postEntities!=null){
//           postEntities.stream().map(postEntityMapper::mapPostEntityTOPostDto);
            List<PostDto> list = postEntities.stream()
                    .map(postEntit -> postEntityMapper.mapPostEntityTOPostDto(postEntit)).
                    collect(Collectors.toList());
            return list;
        }
        return null;
    }

    @Override
    public PostDto getPostById(long id) {
        Optional<PostEntity> optionId = this.postRepository.findById(id);
       return optionId.map(postEnty->postEntityMapper.mapPostEntityTOPostDto(postEnty))
               .orElseThrow(()->new RuntimeException("Post not found by id:"+id));

    }

    @Override
    public PostDto createPost(PostDto postDtoToBeCreated) {
        PostEntity entityToSave=this.postEntityMapper.mapPostDtoToPostEntity(postDtoToBeCreated);
        return this.postEntityMapper.mapPostEntityTOPostDto(this.postRepository.save(entityToSave));
          }

    @Override
    public PostDto updatePost(PostDto postDto, long postId) {
        PostEntity postEntity = this.postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        postEntity.setDescription(postDto.getDescription());
        postEntity.setTitle(postDto.getTitle());
        postEntity.setContent(postDto.getContent());
        return this.postEntityMapper.mapPostEntityTOPostDto(this.postRepository.save(postEntity));
    }

    @Override
    public boolean deletePostById(long postIdToBeDeleted) {
            try {
                PostEntity postEntity = this.postRepository.findById(postIdToBeDeleted).orElseThrow(() -> new ResourceNotFoundException("Post with id not found: " + postIdToBeDeleted));
                this.postRepository.delete(postEntity);
            }catch(Exception e){
                LOGGER.error("Exception while deleting the Posts");
                return false;
            }
        return true;
    }
}
