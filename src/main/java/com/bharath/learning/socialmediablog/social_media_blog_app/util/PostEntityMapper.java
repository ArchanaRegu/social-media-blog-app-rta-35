package com.bharath.learning.socialmediablog.social_media_blog_app.util;

import com.bharath.learning.socialmediablog.social_media_blog_app.dto.PostDto;
import com.bharath.learning.socialmediablog.social_media_blog_app.model.PostEntity;
import org.springframework.stereotype.Component;

@Component
public class PostEntityMapper {
   //map or convert post entity to post dto
   //map or convert post dto to post entity
    public PostDto mapPostEntityTOPostDto(final PostEntity postEntity){
        PostDto postDto=new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setContent(postEntity.getContent());
        postDto.setDescription(postEntity.getDescription());
        postDto.setTitle(postEntity.getTitle());
        return postDto;
    }
    public PostEntity mapPostDtoToPostEntity(final PostDto postDto){
        PostEntity postEntity1=new PostEntity();
        postEntity1.setId(postDto.getId());
        postEntity1.setTitle(postDto.getTitle());
        postEntity1.setContent(postDto.getContent());
        postEntity1.setDescription(postDto.getDescription());
        return postEntity1;
    }
}
