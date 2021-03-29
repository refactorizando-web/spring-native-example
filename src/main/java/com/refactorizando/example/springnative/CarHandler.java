package com.refactorizando.example.springnative;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CarHandler {

  private final CarService service;

  public Mono<ServerResponse> getAll(ServerRequest req) {
    var all = service.findAll(Sort.by("model", "brand"));
    return ok().body(BodyInserters.fromPublisher(all, Car.class));
  }

  public Mono<ServerResponse> getOne(ServerRequest req) {
    var mono = service
        .findById(Long.valueOf(req.pathVariable("id")))
        .switchIfEmpty(Mono.error(() -> new ResponseStatusException(NOT_FOUND)));
    return ok().body(BodyInserters.fromPublisher(mono, Car.class));
  }
}
