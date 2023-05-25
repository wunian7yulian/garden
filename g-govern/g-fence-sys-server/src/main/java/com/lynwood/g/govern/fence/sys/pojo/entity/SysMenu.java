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
 * 菜单管理
 * @TableName sys_menu
 */
@TableName(value ="sys_menu")
@Data
public class SysMenu extends GBaseEntity implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单ID
     */
    private Long parentId;

    /**
     * 路由路径
     */
    private String path;

    /**
     * 组件路径
     */
    private String component;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：0-禁用 1-开启
     */
    private Integer visible;

    /**
     * 跳转路径
     */
    private String redirect;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}