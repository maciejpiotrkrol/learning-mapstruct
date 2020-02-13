package com.learning.mapstruct.basics;

import java.time.LocalDate;
import java.util.Map;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MapsMappers {

  @MapMapping(valueDateFormat = "dd-MM-yyyy")
  Map<String, String> longDateToStringStringMap(Map<Long, LocalDate> source);
}
