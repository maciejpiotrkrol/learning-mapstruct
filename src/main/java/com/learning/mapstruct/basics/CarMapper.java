package com.learning.mapstruct.basics;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CustomerMapper.class)
public interface CarMapper {

  @Mapping(source = "model", target = "name")
  @Mapping(source = "numberOfSeats", target = "seatCount")
  @Mapping(source = "customer", target = "user")
  CarDto carToCarDto(Car car);

  List<CarDto> carsToCarDtos(List<Car> cars);

}
