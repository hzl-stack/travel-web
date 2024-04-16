package org.example.springdemo.helloworld.service;

import org.example.springdemo.helloworld.entity.Car;

import java.util.List;

public interface CarService {

  /**
   * 获取所有汽车信息
   * @return
   */
  List<Car> getAllCars();

  /**
   * 根据id查询汽车信息
   *
   * @param id
   * @return
   */
  Car getCarById(Long id);

  int insert(Car car);
}
