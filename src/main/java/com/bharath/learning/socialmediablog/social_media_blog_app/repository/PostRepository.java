package com.bharath.learning.socialmediablog.social_media_blog_app.repository;

import com.bharath.learning.socialmediablog.social_media_blog_app.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {

}
