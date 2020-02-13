package com.learning.mapstruct.basics;

import java.util.ArrayList;
import java.util.List;
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
    Car car = generateCar();

    CarDto carDto = carMapper.carToCarDto(car);

    assertCarEqualsCarDto(car, carDto);
  }

  @Test
  void carsToCarDtos() {
    List<Car> cars = new ArrayList<>();
    Car car = generateCar();
    cars.add(car);
    cars.add(car);
    cars.add(car);

    List<CarDto> carDtos = carMapper.carsToCarDtos(cars);

    carDtos.forEach(dto -> assertCarEqualsCarDto(car, dto));
  }

  private void assertCarEqualsCarDto(Car car, CarDto carDto) {
    assertEquals(car.getColor(), carDto.getColor());
    assertEquals(car.getModel(), carDto.getName());
    assertEquals(car.getNumberOfSeats(), carDto.getSeatCount());
    assertEquals(String.valueOf(car.getCustomer().getAge()), carDto.getUser().getAge());
    assertEquals(car.getCustomer().getAddress().getCity() + " " + car.getCustomer().getAddress().getStreet() + " " + car.getCustomer().getAddress().getBuildingNumber(), carDto.getUser().getAddress());
    assertEquals(car.getCustomer().getName() + " " + car.getCustomer().getSurname(), carDto.getUser().getName());
  }

  private Car generateCar() {
    Car car = new Car();
    car.setColor(RED);
    car.setModel(MERCEDES);
    car.setNumberOfSeats(SEATS);
    Address address = Address.builder().buildingNumber(BUILDING_NUMBER).city(TEST_CITY).street(TEST_STREET).build();
    Customer customer = Customer.builder().age(AGE).name(TEST_NAME).surname(TEST_SURNAME).address(address).build();
    car.setCustomer(customer);
    return car;
  }
}