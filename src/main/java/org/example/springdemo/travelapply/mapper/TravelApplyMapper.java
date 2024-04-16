package org.example.springdemo.travelapply.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.springdemo.travelapply.entity.TravelApply;

@Mapper
public interface TravelApplyMapper extends BaseMapper<TravelApply>{
}
