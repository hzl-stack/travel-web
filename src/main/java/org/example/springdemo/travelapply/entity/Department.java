package org.example.springdemo.travelapply.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.example.springdemo.travelapply.entity.base.BaseEntity;

@Data
@Accessors(chain = true)
@TableName("t_dept")
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseEntity {

  /**
   * 部门编号
   */
  @TableField(value = "dept_id")
  private String deptId;

  /**
   * 部门名称
   */
  @TableField(value = "dept_name")
  private String deptName;

  /**
   * 上级部门编号
   */
  @TableField(value = "parent_dept")
  private String parentDept;
}
