package org.example.springdemo.travelapply.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DepartmentVo {
  @TableField(value = "dept_id")
  private String deptId;

  @TableField(value = "dept_name")
  private String deptName;

  @TableField(value = "parent_dept")
  private String parentDept;
}
