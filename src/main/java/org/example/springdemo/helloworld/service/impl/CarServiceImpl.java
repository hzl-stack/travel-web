package org.example.springdemo.helloworld.service.impl;

import org.example.springdemo.helloworld.entity.Car;
import org.example.springdemo.helloworld.mapper.CarMapper;
import org.example.springdemo.helloworld.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

  @Autowired
  private CarMapper carMapper;

  @Override
  public List<Car> getAllCars() {
    return carMapper.getAll();
  }

  @Override
  public Car getCarById(Long id) {
    return carMapper.getCarById(id);
  }

  @Override
  public int insert(Car car) {
    return carMapper.insert(car);
  }
}
