package com.bharath.learning.socialmediablog.social_media_blog_app.payLoad;

import com.bharath.learning.socialmediablog.social_media_blog_app.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostResponse {
    //List of PostDTO
    //page number
    //page size
    //total Elements
    //Total pages
    //is lastpage
    private List<PostDto> contents;
    private  int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
    private boolean isLastPage;
}
