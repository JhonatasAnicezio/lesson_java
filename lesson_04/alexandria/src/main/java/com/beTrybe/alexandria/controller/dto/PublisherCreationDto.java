package com.beTrybe.alexandria.controller.dto;

import com.beTrybe.alexandria.entity.Publisher;

public record PublisherCreationDto(String name, String address) {

  public Publisher toEntity() {
    return new Publisher(name, address);
  }
}
