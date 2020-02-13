package com.learning.mapstruct.basics;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CarMapper {

  @Mapping(source = "model", target = "name")
  @Mapping(source = "numberOfSeats", target = "seatCount")
  CarDto carToCarDto(Car car);

}
