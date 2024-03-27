package com.betrybe.podcastmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {

  @GetMapping
  public String getRoot() {
    return "Yay Podcasts!";
  }

  @GetMapping("/{id}")
  public String getPodcast(@PathVariable int id) {
    return "Você pediu pelo podcast de id: %d".formatted(id);
  }
}
