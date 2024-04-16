package org.example.springdemo;

import org.example.springdemo.helloworld.mapper.CarMapper;
import org.example.springdemo.helloworld.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

//@MapperScan("org.example.springdemo.helloworld.mapper.CarMapper")
@SpringBootTest
class SpringDemoApplicationTests {

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void dataSource() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    @Test
    void testGetAll() {
        List<Car> list = carMapper.getAll();
        System.out.println(list);
    }

    @Test
    void testInsert(){
        Car car = new Car((Long) 4L,"111","奔驰", 30.00F,"2022-10-2","新能源");
        int count = carMapper.insert(car);
        System.out.println((count == 1 ? "插入成功" : "插入失败"));
    }
    @Test
    void testDelete(){
        int count = carMapper.delete(4L);
        System.out.println((count == 1 ? "删除成功" : "删除失败"));
    }
    @Test
    void testUpdate(){
        Car car = new Car(6L,"1111","奔驰", 50.00F,"2022-10-2","新能源");
        int count = carMapper.update(car);
        System.out.println((count == 1 ? "更新成功" : "更新失败"));
    }
}
