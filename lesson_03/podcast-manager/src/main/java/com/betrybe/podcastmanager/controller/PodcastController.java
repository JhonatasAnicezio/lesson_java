package com.betrybe.podcastmanager.controller;

import com.betrybe.podcastmanager.model.Podcast;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<Podcast> getPodcast(@PathVariable int id) {
    if (id > 1000) {
      return ResponseEntity.notFound().build();
    }

    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu Podcast");
    podcast.setUrl("http://meupodcast.com.br");

    return ResponseEntity.ok(podcast);
  }

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return "Você pesquisou pelo podcast de titulo: %s".formatted(title);
  }
}
