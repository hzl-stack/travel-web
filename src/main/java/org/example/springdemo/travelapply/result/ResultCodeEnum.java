package org.example.springdemo.travelapply.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCodeEnum {

    SUCCESS(200, "成功"),
    FAIL(201, "失败"),
    PARAM_ERROR(202, "参数不正确"),
    SERVICE_ERROR(203, "服务异常"),
    DATA_ERROR(204, "数据异常"),
    DATA_UPDATE_ERROR(205, "数据版本异常"),
    DEPARTMENT_NAME_NULL(206, "部门名称不能为空"),
    EMPLOYEE_INFO_NULL(207, "员工信息存在必填字段为空"),
    TEL_ERROR(208, "手机号格式错误"),
    EMPLOYEE_NUMBER_EXIST(209, "人员信息已存在"),
    APPLY_CODE_NULL(210, "申请单号不能为空"),
    DEPARTMENT_EXIST(211, "部门编码已存在"),
    PERSON_ID_NULL(212,"员工编号不能为空"),
    APPLY_CODE_REPEAT(213, "申请单已存在"),
    APPLY_REQUIREDINFO_UNCOMPELETE(214,"申请单必填信息未完成");


    private Integer code;
    private String message;
}
