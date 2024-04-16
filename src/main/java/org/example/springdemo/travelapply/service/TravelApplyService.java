package org.example.springdemo.travelapply.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springdemo.travelapply.entity.TravelApply;
import org.example.springdemo.travelapply.entity.vo.TravelApplyVo;

public interface TravelApplyService extends IService<TravelApply> {

    boolean addTravelApply(TravelApplyVo travelApplyVo);
}
