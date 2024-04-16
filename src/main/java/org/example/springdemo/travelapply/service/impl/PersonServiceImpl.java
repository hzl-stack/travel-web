package org.example.springdemo.travelapply.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springdemo.travelapply.entity.Person;
import org.example.springdemo.travelapply.entity.vo.PersonVo;
import org.example.springdemo.travelapply.exception.TAException;
import org.example.springdemo.travelapply.mapper.PersonMapper;
import org.example.springdemo.travelapply.result.ResultCodeEnum;
import org.example.springdemo.travelapply.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

    private static final Pattern PHONE_NUMBER_PATTERN = Pattern.compile("^1[3456789]\\d{9}$");

    @Autowired
    private PersonMapper personMapper;

    @Override
    public boolean addPerson(PersonVo personVo) {
        if (StringUtils.isEmpty(personVo.getPersonId()) ||
                StringUtils.isEmpty(personVo.getPersonName()) ||
                StringUtils.isEmpty(personVo.getDept()) ||
                StringUtils.isEmpty(personVo.getFamilyName()) ||
                Objects.isNull(personVo.getBeginTime()) ||
                Objects.isNull(personVo.getEndTime()) ||
                Objects.isNull(personVo.getRelation())) {
            throw new TAException(ResultCodeEnum.EMPLOYEE_INFO_NULL);
        }
        if (StringUtils.isNoneEmpty(personVo.getPhone())) {
            if (!isValidPhoneNumber(personVo.getPhone())) {
                throw new TAException(ResultCodeEnum.TEL_ERROR);
            }
        }

        LambdaQueryWrapper<Person> queryWrapper = new LambdaQueryWrapper<Person>();
        queryWrapper.eq(Person::getPersonId, personVo.getPersonId());
        Person PersonIsExist = baseMapper.selectOne(queryWrapper);

        if (Objects.nonNull(PersonIsExist)) {
            throw new TAException(ResultCodeEnum.EMPLOYEE_NUMBER_EXIST);
        }

        Person person = new Person();
        BeanUtils.copyProperties(personVo, person);
        int insert = baseMapper.insert(person);
        if (insert > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public PersonVo getPersonByCode(String personCode) {
        PersonVo personVo = new PersonVo();
        //1.获取所有奖罚单数据记录
        QueryWrapper<Person> personQueryWrapper = new QueryWrapper<>();
        personQueryWrapper.eq("person_id", personCode);
        Person person = baseMapper.selectOne(personQueryWrapper);
        BeanUtils.copyProperties(person, personVo);
        return personVo;
    }

    @Override
    public String getPersonDepartmentByCode(String personCode) {
        LambdaQueryWrapper<Person> personQueryWrapper = new LambdaQueryWrapper<>();
        personQueryWrapper.eq(Person::getPersonId, personCode);
        Person person = baseMapper.selectOne(personQueryWrapper);
        return person.getDept();
    }

    /**
     * 校验手机号
     *
     * @param phoneNumber
     * @return
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        Matcher matcher = PHONE_NUMBER_PATTERN.matcher(phoneNumber);
        return matcher.matches();
    }
}
