package com.betrybe.podcastmanager.service;

import com.betrybe.podcastmanager.model.Podcast;
import org.springframework.stereotype.Service;

@Service
public class PodcastService {
  public Podcast findPodcastById(long id) {
    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("http://meupodcast.com.br");

    return podcast;
  }
}
