package com.lynwood.g.base.rock.mybatis;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @Author Lynwood
 * @Date 2023/5/24
 * @Version 1.0
 */
public class GBaseEntity {

    @TableLogic
    private Integer deleted;

    @Version
    private Long version;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT)
    private Long createBy;

    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    @TableField(fill = FieldFill.INSERT_UPDATE,select = false)
    private Date updateTime;

    @TableField(fill = FieldFill.INSERT_UPDATE,select = false)
    private Long updateBy;

    @TableField(fill = FieldFill.INSERT_UPDATE,select = false)
    private String updateUser;
}
