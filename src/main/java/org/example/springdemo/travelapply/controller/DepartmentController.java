package org.example.springdemo.travelapply.controller;

import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.example.springdemo.travelapply.entity.Department;
import org.example.springdemo.travelapply.entity.vo.DepartmentVo;
import org.example.springdemo.travelapply.exception.TAException;
import org.example.springdemo.travelapply.result.Result;
import org.example.springdemo.travelapply.result.ResultCodeEnum;
import org.example.springdemo.travelapply.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/travel-apply/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * 获取所有部门数据
     *
     * @return 部门列表
     */
    @GetMapping("getAllDepts")
    public Result<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return Result.ok(departments);
    }

    @PostMapping("addDept")
    public Result addDepartment(@RequestBody DepartmentVo departmentVo) {
        if (StringUtils.isEmpty(departmentVo.getDeptName()) || StringUtils.isEmpty(departmentVo.getDeptId())) {
            throw new TAException(ResultCodeEnum.DEPARTMENT_NAME_NULL);
        }
        boolean save = departmentService.saveDept(departmentVo);
        if (save) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
