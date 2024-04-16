package org.example.springdemo.travelapply.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PersonVo {
    /**
     * 人员编号
     */
    @TableField(value = "person_id")
    private String personId;

    /**
     * 人员姓名
     */
    @TableField(value = "person_name")
    private String personName;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 所属部门
     */
    @TableField(value = "dept")
    private String dept;

    /**
     * 开始时间
     */
    @JsonFormat(pattern = "YYYY-MM-DD HH-mm-ss")
    @TableField(value ="begin_time")
    private Date beginTime;

    /**
     * 结束时间
     */
    @JsonFormat(pattern = "YYYY-MM-DD HH-mm-ss")
    @TableField(value = "end_time")
    private Date endTime;

    /**
     * 亲属名称
     */
    @TableField(value = "family_name")
    private String familyName;

    /**
     * 亲属关系
     */
    @TableField(value = "relation")
    private String relation;

    /**
     * 联系方式
     */
    @TableField(value = "phone")
    private String phone;
}
