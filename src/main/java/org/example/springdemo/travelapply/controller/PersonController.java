package org.example.springdemo.travelapply.controller;

import org.example.springdemo.travelapply.entity.Person;
import org.example.springdemo.travelapply.entity.vo.PersonVo;
import org.example.springdemo.travelapply.exception.TAException;
import org.example.springdemo.travelapply.result.Result;
import org.example.springdemo.travelapply.result.ResultCodeEnum;
import org.example.springdemo.travelapply.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/travel-apply/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(value = "/add")
    public Result<PersonVo> addPerson(@RequestBody PersonVo personVo) {
        boolean success = personService.addPerson(personVo);
        if (success) {
            return Result.ok(personVo);
        } else {
            return Result.fail(personVo);
        }
    }

    @PostMapping("getPersonById/{personCode}")
    public PersonVo getPersonById(@PathVariable String personCode) {
        if(personCode.isEmpty()){
            throw new TAException(ResultCodeEnum.PERSON_ID_NULL);
        }
        PersonVo personVo = personService.getPersonByCode(personCode);
        return personVo;
    }

    @PostMapping("getPersonDepartmentByCode/{personCode}")
    public Result<String> getPersonDepartmentByCode(@PathVariable String personCode){
        if(personCode.isEmpty()){
            throw new TAException(ResultCodeEnum.PERSON_ID_NULL);
        }
        String dept = personService.getPersonDepartmentByCode(personCode);
        return Result.ok(dept);
    }

}
