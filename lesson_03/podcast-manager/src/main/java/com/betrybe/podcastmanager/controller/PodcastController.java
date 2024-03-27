package com.betrybe.podcastmanager.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return "Você pesquisou pelo podcast de titulo: %s".formatted(title);
  }
}
