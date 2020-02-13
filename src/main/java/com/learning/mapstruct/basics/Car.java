package com.learning.mapstruct.basics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {
  private String model;
  private int numberOfSeats;
  private String color;
  private Customer customer;
}
