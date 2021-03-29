package com.refactorizando.example.springnative;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class CarRoutes {


  @Bean
  public RouterFunction<ServerResponse> routes(CarHandler handler) {
    return route().path(
        "/car", builder -> builder
            .GET("/", handler::getAll)
            .GET("/{id}", handler::getOne)
    ).build();
  }
}
