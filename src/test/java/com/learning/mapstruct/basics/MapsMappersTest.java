package com.learning.mapstruct.basics;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MapsMappersTest {

  @Autowired
  MapsMappers mapsMappers;

  @Test
  void longDateToStringStringMap() {
    Map<Long, LocalDate> source = new HashMap<>();
    source.put(1L, LocalDate.of(2000, 2, 2));
    source.put(2L, LocalDate.of(2020, 1, 26));
    source.put(3L, LocalDate.of(1999, 2, 20));

    Map<String, String> result = mapsMappers.longDateToStringStringMap(source);

    assertEquals(result.get("1"), "02-02-2000");
    assertEquals(result.get("2"), "26-01-2020");
    assertEquals(result.get("3"), "20-02-1999");
  }
}