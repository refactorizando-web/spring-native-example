package com.refactorizando.example.springnative;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface CarRepository extends ReactiveSortingRepository<Car, Long> {

}
