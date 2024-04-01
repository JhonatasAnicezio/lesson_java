package com.betrybe.podcastmanager.controller;

import com.betrybe.podcastmanager.Dto.PodcastDto;
import com.betrybe.podcastmanager.model.Podcast;
import com.betrybe.podcastmanager.service.PodcastService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/podcasts")
public class PodcastController {
  private PodcastService podcastService;

  @Autowired
  public PodcastController(PodcastService podcastService) {
    this.podcastService = podcastService;
  }

  @GetMapping
  public String getRoot() {
    return "Yay Podcasts!";
  }

  @GetMapping("/{id}")
  public ResponseEntity<PodcastDto> getPodcast(@PathVariable int id) {
    if (id > 1000) {
      return ResponseEntity.notFound().build();
    }

    Podcast podcast = podcastService.findPodcastById(id);

    PodcastDto podcastDto = new PodcastDto(
        podcast.getId(), podcast.getName(), podcast.getUrl()
    );

    return ResponseEntity.ok(podcastDto);
  }

  @PostMapping
  public ResponseEntity<Podcast> createPodcast(@RequestBody Podcast newPodcast) {
    Podcast savedPodcast = podcastService.savePodcast(newPodcast);

    return ResponseEntity.status(HttpStatus.CREATED).body(savedPodcast);
  }

  @GetMapping("/search")
  public String searchPodcast(@RequestParam String title) {
    return "Você pesquisou pelo podcast de titulo: %s".formatted(title);
  }
}
