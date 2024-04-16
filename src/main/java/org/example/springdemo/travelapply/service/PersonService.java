package org.example.springdemo.travelapply.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springdemo.travelapply.entity.Person;
import org.example.springdemo.travelapply.entity.vo.DepartmentVo;
import org.example.springdemo.travelapply.entity.vo.PersonVo;
import org.springframework.stereotype.Service;

public interface PersonService extends IService<Person> {

    /**
     * 新增人员
     * @return true 成功 false 失败
     */
    boolean addPerson(PersonVo personVo);


    /**
     * 根据编号查询人员信息
     * @param personCode
     * @return PersonVo
     */
    PersonVo getPersonByCode(String personCode);

    /**
     * 根据用户编号查询部门信息
     * @param personCode
     * @return
     */
    String getPersonDepartmentByCode(String personCode);
}
