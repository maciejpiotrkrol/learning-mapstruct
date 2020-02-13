package com.learning.mapstruct.basics;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {
  private String name;
  private int age;
  private String address;

}
