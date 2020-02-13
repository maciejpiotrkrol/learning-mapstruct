package com.learning.mapstruct.basics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {

  private String name;
  private String surname;
  private int age;
  private Address address;
}
