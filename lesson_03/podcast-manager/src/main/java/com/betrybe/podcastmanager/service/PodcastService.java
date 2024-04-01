package com.betrybe.podcastmanager.service;

import com.betrybe.podcastmanager.model.Podcast;
import java.util.Random;
import org.springframework.stereotype.Service;

@Service
public class PodcastService {
  public Podcast findPodcastById(long id) {
    Podcast podcast = new Podcast();
    podcast.setId(id);
    podcast.setName("Meu podcast");
    podcast.setUrl("http://meupodcast.com.br");

    podcast.setScretToken("super-secret-token-123");

    return podcast;
  }

  public Podcast savePodcast(Podcast newPodcast) {
    Podcast savedPodcast = new Podcast();

    savedPodcast.setId(new Random().nextLong(0, 1000));
    savedPodcast.setName(newPodcast.getName());
    savedPodcast.setUrl(newPodcast.getUrl());

    return savedPodcast;
  }
}
