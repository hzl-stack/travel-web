package org.example.springdemo.travelapply.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springdemo.travelapply.entity.Department;
import org.example.springdemo.travelapply.entity.vo.DepartmentVo;
import org.example.springdemo.travelapply.exception.TAException;
import org.example.springdemo.travelapply.mapper.DepartmentMapper;
import org.example.springdemo.travelapply.result.ResultCodeEnum;
import org.example.springdemo.travelapply.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {

    @Override
    public List<Department> getAllDepartments() {
        return baseMapper.selectList(null);
    }

    @Override
    public boolean saveDept(DepartmentVo departmentVo) {
        LambdaQueryWrapper<Department> queryWrapper = new LambdaQueryWrapper<Department>();
        queryWrapper.eq(Department::getDeptId, departmentVo.getDeptId());
        Department departmentExist = baseMapper.selectOne(queryWrapper);

        if (Objects.nonNull(departmentExist)) {
            throw new TAException(ResultCodeEnum.DEPARTMENT_EXIST);
        }

        Department department = new Department();
        BeanUtils.copyProperties(departmentVo, department);
        int insert = baseMapper.insert(department);
        if (insert > 0) {
            return true;
        }

        return false;
    }
}
