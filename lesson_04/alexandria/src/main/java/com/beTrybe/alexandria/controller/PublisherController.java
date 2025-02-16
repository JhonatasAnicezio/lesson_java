package com.beTrybe.alexandria.controller;

import com.beTrybe.alexandria.controller.dto.PublisherCreationDto;
import com.beTrybe.alexandria.controller.dto.PublisherDto;
import com.beTrybe.alexandria.entity.Publisher;
import com.beTrybe.alexandria.service.PublisherService;
import com.beTrybe.alexandria.service.exception.PublisherNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/publishers")
public class PublisherController {

  private final PublisherService publisherService;

  @Autowired
  public PublisherController(PublisherService publisherService) {
    this.publisherService = publisherService;
  }

  @GetMapping("/{id}")
  public PublisherDto getPublisherById(@PathVariable Long id) throws PublisherNotFoundException {
    return PublisherDto.fromEntity(
        publisherService.findById(id)
    );
  }

  @GetMapping
  public List<PublisherDto> getAllPublishers() {
    List<Publisher> allPublishers = publisherService.findAll();
    return allPublishers.stream()
        .map(PublisherDto::fromEntity)
        .toList();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PublisherDto createPublisher(@RequestBody PublisherCreationDto publisherCreationDto) {
    return PublisherDto.fromEntity(
        publisherService.create(publisherCreationDto.toEntity())
    );
  }

  @PutMapping("/{id}")
  public PublisherDto updatePublisher(@PathVariable Long id,
                                      @RequestBody PublisherCreationDto publisherCreationDto) throws PublisherNotFoundException {
    return PublisherDto.fromEntity(
        publisherService.update(id, publisherCreationDto.toEntity())
    );
  }

  @DeleteMapping("/{id}")
  public PublisherDto deletePublisherById(@PathVariable Long id) throws PublisherNotFoundException {
    return PublisherDto.fromEntity(
        publisherService.delete(id)
    );
  }
}
