package org.example.springdemo.travelapply.entity.base;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.ASSIGN_UUID)
  private String id;

  @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
  @TableField(value = "create_time", fill = FieldFill.INSERT)
  private Date createTime;

  @JsonFormat(pattern = "YYYY-MM-DD HH:mm:ss")
  @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;

  @TableField(value = "dr", fill = FieldFill.INSERT_UPDATE)
  @TableLogic
  private Integer dr;
}
