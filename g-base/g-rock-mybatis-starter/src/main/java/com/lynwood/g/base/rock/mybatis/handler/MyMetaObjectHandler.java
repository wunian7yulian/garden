package com.lynwood.g.base.rock.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author： Lynwood
 */
@Slf4j
@Component
@Configuration
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增填充创建时间
     *
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        Date now = new Date();
        this.setUpdateInfo(metaObject, now, 1234L, "张三4");
        this.setCreateInfo(metaObject, now, 123L, "张三");
    }

    /**
     * 更新填充更新时间
     *
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.setUpdateInfo(metaObject, new Date(), 1234444L, "李四");
    }

    private void setUpdateInfo(MetaObject metaObject, Date now, Long userId, String nickName) {
        Object updateTime = this.getFieldValByName("updateTime", metaObject);
        if (null == updateTime) {
            this.strictInsertFill(metaObject, "updateTime", () -> now, Date.class);
        }
        Object updateBy = this.getFieldValByName("updateBy", metaObject);
        if (null == updateBy) {
            this.strictInsertFill(metaObject, "updateBy", () -> userId, Long.class);
        }
        Object updateUser = this.getFieldValByName("updateUser", metaObject);
        if (null == updateUser) {
            this.strictInsertFill(metaObject, "updateUser", () -> nickName, String.class);
        }
    }

    private void setCreateInfo(MetaObject metaObject, Date now, Long userId, String nickName) {

        Object createTime = this.getFieldValByName("createTime", metaObject);
        if (null == createTime) {
            this.strictInsertFill(metaObject, "createTime", () -> now, Date.class);
        }
        Object createBy = this.getFieldValByName("createBy", metaObject);
        if (null == createBy) {
            this.strictInsertFill(metaObject, "createBy", () -> userId, Long.class);
        }
        Object createUser = this.getFieldValByName("createUser", metaObject);
        if (null == createUser) {
            this.strictInsertFill(metaObject, "createUser", () -> nickName, String.class);
        }
    }

}
