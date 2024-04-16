package org.example.springdemo.travelapply.utils;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", DateUtil.date(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("updateTime", DateUtil.date(System.currentTimeMillis()), metaObject);
        this.setFieldValByName("dr",0,metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", DateUtil.date(System.currentTimeMillis()), metaObject);
    }
}
