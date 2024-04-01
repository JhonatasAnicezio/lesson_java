package com.betrybe.podcastmanager;

import com.betrybe.podcastmanager.model.Podcast;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DesserializationExample {

  public static void main(String[] args) throws JsonProcessingException {
    String json = "{\"id\": 123456789,\"name\": \"podcast01\","
        + " \"url\": \"https://podcast01.com\"}";

    ObjectMapper mapper = new ObjectMapper();

    Podcast podcast = mapper.readValue(json, Podcast.class);

    System.out.println(podcast.getName());
    System.out.println(podcast.getUrl());
  }
}
