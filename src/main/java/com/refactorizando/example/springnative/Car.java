package com.refactorizando.example.springnative;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Car implements Serializable {

  @Id
  private Long id;

  private String model;

  private String brand;

  private String color;

  private LocalDate createdDate;

}
