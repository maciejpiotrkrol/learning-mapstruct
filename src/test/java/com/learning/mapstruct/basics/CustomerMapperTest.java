package com.learning.mapstruct.basics;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerMapperTest {

  public static final String TEST_CITY = "TestCity";
  public static final String TEST_STREET = "TestStreet";
  public static final String UPDATED_CITY = "UpdatedCity";
  public static final String UPDATED_STREET = "UpdatedStreet";
  public static final String TEST_SURNAME = "TestSurname";
  public static final String TEST_NAME = "TestName";
  public static final String AGE_STRING = "18";
  public static final int AGE = 18;
  public static final int BUILDING_NUMBER = 41;
  public static final int UPDATED_BUILDING_NUMBER = 58;

  @Autowired
  private CustomerMapper customerMapper;

  @Test
  void customerToCustomerDto() {
    Address address = Address.builder().buildingNumber(BUILDING_NUMBER).city(TEST_CITY).street(TEST_STREET).build();
    Customer customer = Customer.builder().age(AGE).name(TEST_NAME).surname(TEST_SURNAME).address(address).build();

    CustomerDto customerDto = customerMapper.customerToCustomerDto(customer);

    assertEquals(AGE_STRING, customerDto.getAge());
    assertEquals(TEST_CITY + " " + TEST_STREET + " " + BUILDING_NUMBER, customerDto.getAddress());
    assertEquals(TEST_NAME + " " + TEST_SURNAME, customerDto.getName());
  }

  @Test
  void customerDtoToCustomer() {
    CustomerDto customerDto = CustomerDto.builder().age(AGE_STRING).name(TEST_NAME + " " + TEST_SURNAME).address(TEST_CITY + " " + TEST_STREET + " " + BUILDING_NUMBER).build();

    Customer customer = customerMapper.customerDtoToCustomer(customerDto);

    assertEquals(AGE, customer.getAge());
    assertEquals(TEST_CITY, customer.getAddress().getCity());
    assertEquals(TEST_STREET, customer.getAddress().getStreet());
    assertEquals(BUILDING_NUMBER, customer.getAddress().getBuildingNumber());
    assertEquals(TEST_NAME, customer.getName());
    assertEquals(TEST_SURNAME, customer.getSurname());
  }

  @Test
  void updateCustomerFromDto() {
    CustomerDto customerDto = CustomerDto.builder().age(AGE_STRING).address(UPDATED_CITY + " " + UPDATED_STREET + " " + UPDATED_BUILDING_NUMBER).build();
    Address address = Address.builder().buildingNumber(BUILDING_NUMBER).city(TEST_CITY).street(TEST_STREET).build();
    Customer customer = Customer.builder().age(AGE).name(TEST_NAME).surname(TEST_SURNAME).address(address).build();

    customer = customerMapper.updateCustomerFromDto(customerDto, customer);

    assertEquals(AGE, customer.getAge());
    assertEquals(UPDATED_CITY, customer.getAddress().getCity());
    assertEquals(UPDATED_STREET, customer.getAddress().getStreet());
    assertEquals(UPDATED_BUILDING_NUMBER, customer.getAddress().getBuildingNumber());
    assertEquals(TEST_NAME, customer.getName());
    assertEquals(TEST_SURNAME, customer.getSurname());
  }
}