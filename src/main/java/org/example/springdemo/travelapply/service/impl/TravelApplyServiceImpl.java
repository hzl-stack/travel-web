package org.example.springdemo.travelapply.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.example.springdemo.travelapply.entity.TravelApply;
import org.example.springdemo.travelapply.entity.vo.TravelApplyVo;
import org.example.springdemo.travelapply.exception.TAException;
import org.example.springdemo.travelapply.mapper.TravelApplyMapper;
import org.example.springdemo.travelapply.result.ResultCodeEnum;
import org.example.springdemo.travelapply.service.TravelApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TravelApplyServiceImpl extends ServiceImpl<TravelApplyMapper, TravelApply> implements TravelApplyService {

    @Autowired
    private TravelApplyMapper travelApplyMapper;


    @Override
    public boolean addTravelApply(TravelApplyVo travelApplyVo) {

        LambdaQueryWrapper<TravelApply> queryWrapper = new LambdaQueryWrapper<TravelApply>();
        queryWrapper.eq(TravelApply::getApplyCode, travelApplyVo.getApplyCode());
        TravelApply travelApplyExist = baseMapper.selectOne(queryWrapper);

        if (Objects.nonNull(travelApplyExist)) {
            throw new TAException(ResultCodeEnum.APPLY_CODE_REPEAT);
        }

        if (StringUtils.isEmpty(travelApplyVo.getApplyName()) ||
                StringUtils.isEmpty(travelApplyVo.getCostDept()) ||
                StringUtils.isEmpty(travelApplyVo.getAmount())) {
            throw new TAException(ResultCodeEnum.APPLY_REQUIREDINFO_UNCOMPELETE);
        }

        TravelApply travelApply = new TravelApply();
        BeanUtils.copyProperties(travelApplyVo, travelApply);
        int insert = travelApplyMapper.insert(travelApply);
        return insert > 0;
    }
}
