package com.lynwood.g.base.rock.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author： Lynwood
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充创建时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        Object createTime = this.getFieldValByName("createTime", metaObject);
        if (null == createTime) {
            this.setFieldValByName("createTime", now, metaObject);
        }
        Object updateTime = this.getFieldValByName("updateTime", metaObject);
        if (null == updateTime) {
            this.setFieldValByName("updateTime", now, metaObject);
        }
    }

    /**
     * 更新填充更新时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Date now = new Date();
        Object updateTime = this.getFieldValByName("updateTime", metaObject);
        if (null == updateTime) {
            this.setFieldValByName("updateTime", now, metaObject);
        }
    }

}
