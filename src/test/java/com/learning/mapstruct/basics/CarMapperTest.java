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
  public static final String TEST_CITY = "TestCity";
  public static final String TEST_STREET = "TestStreet";
  public static final String TEST_SURNAME = "TestSurname";
  public static final String TEST_NAME = "TestName";
  public static final String AGE_STRING = "18";
  public static final int AGE = 18;
  public static final int BUILDING_NUMBER = 41;

  @Autowired
  private CarMapper carMapper;

  @Test
  void carToCarDto() {
    Car car = new Car();
    car.setColor(RED);
    car.setModel(MERCEDES);
    car.setNumberOfSeats(SEATS);
    Address address = Address.builder().buildingNumber(BUILDING_NUMBER).city(TEST_CITY).street(TEST_STREET).build();
    Customer customer = Customer.builder().age(AGE).name(TEST_NAME).surname(TEST_SURNAME).address(address).build();
    car.setCustomer(customer);

    CarDto carDto = carMapper.carToCarDto(car);

    assertEquals(RED, carDto.getColor());
    assertEquals(MERCEDES, carDto.getName());
    assertEquals(SEATS, carDto.getSeatCount());
    assertEquals(AGE_STRING, carDto.getUser().getAge());
    assertEquals(TEST_CITY + " " + TEST_STREET + " " + BUILDING_NUMBER, carDto.getUser().getAddress());
    assertEquals(TEST_NAME + " " + TEST_SURNAME, carDto.getUser().getName());
  }
}