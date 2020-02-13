package com.learning.mapstruct.basics;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "name", expression = "java(customer.getName() + \" \" + customer.getSurname())")
  CustomerDto customerToCustomerDto(Customer customer);

  default String addressToString(Address address) {
    return address.getCity() + " " + address.getStreet() + " " + address.getBuildingNumber();
  }

}
