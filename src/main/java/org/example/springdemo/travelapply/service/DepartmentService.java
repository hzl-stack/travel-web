package org.example.springdemo.travelapply.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springdemo.travelapply.entity.Department;
import org.example.springdemo.travelapply.entity.vo.DepartmentVo;

import java.util.List;

public interface DepartmentService extends IService<Department> {

  /**
   * 获取所有的部门列表
   * @return 部门列表
   */
  List<Department> getAllDepartments();

  boolean saveDept(DepartmentVo departmentVo);
}
