package com.learning.mapstruct.basics;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  @Mapping(target = "name", expression = "java(customer.getName() + \" \" + customer.getSurname())")
  CustomerDto customerToCustomerDto(Customer customer);

  @Mapping(target = "name", expression = "java(customerDto.getName().split(\" \")[0])")
  @Mapping(target = "surname", expression = "java(customerDto.getName().split(\" \")[1])")
  Customer customerDtoToCustomer(CustomerDto customerDto);

  default String addressToString(Address address) {
    return address.getCity() + " " + address.getStreet() + " " + address.getBuildingNumber();
  }

  default Address stringToAddress(String address){
    String[] addressArray = address.split(" ");
    return Address.builder().city(addressArray[0]).street(addressArray[1]).buildingNumber(Integer.parseInt(addressArray[2])).build();
  }

}
