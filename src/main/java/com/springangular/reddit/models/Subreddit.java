package com.springangular.reddit.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Subreddit {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Community name is required!")
  private String name;

  @NotBlank(message = "Description name is required!")
  private String description;

  @OneToMany(fetch = FetchType.LAZY)
  private List<Post> posts;

  @ManyToOne(fetch = FetchType.LAZY)
  private User user;

  private Instant creationDate;
}
