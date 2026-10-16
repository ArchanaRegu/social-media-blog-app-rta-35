package com.bharath.learning.socialmediablog.social_media_blog_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="posts")
public class PostEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  @Column(name="title")
  private String title;
  @Column(name="description")
  private String description;
  @Column(name="content")
  private String content;
}
