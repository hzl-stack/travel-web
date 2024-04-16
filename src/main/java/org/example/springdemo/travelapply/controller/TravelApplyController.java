package org.example.springdemo.travelapply.controller;

import org.example.springdemo.travelapply.entity.vo.TravelApplyVo;
import org.example.springdemo.travelapply.result.Result;
import org.example.springdemo.travelapply.service.TravelApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/travel-apply/apply-info")
public class TravelApplyController {

    @Autowired
    private TravelApplyService travelApplyService;

    @PostMapping("/add")
    public Result<TravelApplyVo> addNewTravelApply(@RequestBody TravelApplyVo travelApplyVo) {
        boolean success = travelApplyService.addTravelApply(travelApplyVo);
        if (success) {
            return Result.ok(travelApplyVo);
        } else {
            return Result.fail(travelApplyVo);
        }
    }
}
