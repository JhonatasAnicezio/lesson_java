package com.betrybe.podcastmanager.model;

public class Podcast {
  private long id;
  private String name;
  private String url;

  private String scretToken;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getScretToken() {
    return scretToken;
  }

  public void setScretToken(String scretToken) {
    this.scretToken = scretToken;
  }
}
