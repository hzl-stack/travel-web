package org.example.springdemo.travelapply.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = false)
@EqualsAndHashCode(callSuper = false)
public class TravelApplyVo {
    @TableField(value = "apply_code")
    private String applyCode;

    @TableField(value = "apply_name")
    private String applyName;

    @TableField(value = "apply_date")
    @JsonFormat(pattern = "HHHH-MM-DD HH:mm:ss")
    private Date applyDate;

    @TableField(value = "cost_dept")
    private String costDept;

    @TableField(value = "amount")
    private String amount;

    @TableField(value = "reasons")
    private String reasons;

    @TableField(value = "notes")
    private String notes;
}
