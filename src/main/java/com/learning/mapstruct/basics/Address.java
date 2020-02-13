package com.learning.mapstruct.basics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Address {
  private String city;
  private String street;
  private int buildingNumber;
}
