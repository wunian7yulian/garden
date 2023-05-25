package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 角色表
 * @TableName sys_role
 */
@TableName(value ="sys_role")
@Data
public class SysRole extends GBaseEntity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 角色类型 
     */
    private Integer type;

    /**
     * 备注信息

     */
    private String remark;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 角色状态：0-正常；1-停用
     */
    private Integer status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}