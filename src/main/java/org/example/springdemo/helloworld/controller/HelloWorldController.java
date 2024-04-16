package org.example.springdemo.helloworld.controller;

import org.example.springdemo.helloworld.entity.Car;
import org.example.springdemo.helloworld.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class HelloWorldController {

  @Autowired
  private CarService carService;

  @GetMapping(value = "/index")
  public String hello() {
    return "hello world";
  }

  @GetMapping(value = "/all")
  public List<Car> getAllCar(){
    return carService.getAllCars();
  }

  @GetMapping(value = "/car")
  @ResponseBody
  public Car getCarById(@RequestParam Long id){
    return carService.getCarById(id);
  }

  @PostMapping(value = "/insert")
  @ResponseBody
  public int insert(@RequestBody Car car){
    return carService.insert(car);
  }
}
