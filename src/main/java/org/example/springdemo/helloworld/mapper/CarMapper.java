package org.example.springdemo.helloworld.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.springdemo.helloworld.entity.Car;

import java.util.List;

@Mapper
public interface CarMapper {

  /**
   * 查询所有汽车
   * @return
   */
  List<Car> getAll();

  /**
   * 插入汽车
   * @param car
   * @return
   */
  int insert(Car car);

  /**
   * 删除汽车
   * @param id
   * @return
   */
  int delete(Long id);

  /**
   * 更新汽车
   * @param car
   * @return
   */
  int update(Car car);

  /**
   * 根据id查询对应的汽车
   * @param id
   * @return
   */
  Car getCarById(Long id);
}
