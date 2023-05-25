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
 * 权限表
 * @TableName sys_permission
 */
@TableName(value ="sys_permission")
@Data
public class SysPermission extends GBaseEntity implements Serializable {
    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 菜单模块ID
     */
    private Long menuId;

    /**
     * URL权限标识
     */
    private String urlPerm;

    /**
     * 按钮标识
     */
    private String btnSign;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}