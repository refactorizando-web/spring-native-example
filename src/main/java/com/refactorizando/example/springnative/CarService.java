package com.refactorizando.example.springnative;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  public Mono<Car> findById(Long id) {
    return carRepository
        .findById(id)
        .doOnNext(p -> log.info("Car with id " + p.getId() + " found in cache"));
  }

  public Flux<Car> findAll(Sort sort) {
    return carRepository.findAll(sort);
  }
}
