package org.example.springdemo.helloworld.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
  private Long id;
  private String carNum;
  private String brand;
  private Float guidePrice;
  private String produceTime;
  private String carType;
}
