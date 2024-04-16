package org.example.springdemo.travelapply.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.springdemo.travelapply.entity.Person;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PersonMapper extends BaseMapper<Person> {
}
