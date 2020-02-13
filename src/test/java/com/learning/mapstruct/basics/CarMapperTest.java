package com.learning.mapstruct.basics;

import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarMapperTest {

  public static final String RED = "Red";
  public static final String MERCEDES = "Mercedes";
  public static final int SEATS = 5;

  @Autowired
  private CarMapper carMapper;

  @Test
  void carToCarDto() {
    Car car = new Car();
    car.setColor(RED);
    car.setModel(MERCEDES);
    car.setNumberOfSeats(SEATS);

    CarDto carDto = carMapper.carToCarDto(car);

    assertEquals(RED, carDto.getColor());
    assertEquals(MERCEDES, carDto.getName());
    assertEquals(SEATS, carDto.getSeatCount());
  }
}