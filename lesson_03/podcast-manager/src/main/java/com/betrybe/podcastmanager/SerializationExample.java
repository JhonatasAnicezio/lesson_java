package com.betrybe.podcastmanager;

import com.betrybe.podcastmanager.Dto.PodcastDto;
import com.betrybe.podcastmanager.model.Podcast;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationExample {

  public static void main(String[] args) throws JsonProcessingException {
    Podcast podcast = new Podcast();

    podcast.setId(123456789);
    podcast.setName("Podcast 01");
    podcast.setUrl("https://podcast01.com.br");

    PodcastDto podcastDto = new PodcastDto(
        podcast.getId(),
        podcast.getName(),
        podcast.getUrl()
    );

    ObjectMapper mapper = new ObjectMapper();
    String json = mapper.writeValueAsString(podcastDto);
    System.out.println(json);
  }
}
