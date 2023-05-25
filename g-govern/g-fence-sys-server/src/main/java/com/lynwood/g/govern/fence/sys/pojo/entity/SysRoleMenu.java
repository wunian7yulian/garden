package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色和菜单关联表
 * @TableName sys_role_menu
 */
@TableName(value ="sys_role_menu")
@Data
public class SysRoleMenu extends GBaseEntity implements Serializable {
    /**
     * 角色ID
     */
    private Long roleId;

    /**
     * 菜单ID
     */
    private Long menuId;

    /**
     * 选中状态 ui使用 1-半选中 2-选中
     */
    private Integer checkStatus;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}