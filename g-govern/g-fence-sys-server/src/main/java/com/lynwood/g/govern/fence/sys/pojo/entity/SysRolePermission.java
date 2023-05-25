package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色权限表
 * @TableName sys_role_permission
 */
@TableName(value ="sys_role_permission")
@Data
public class SysRolePermission extends GBaseEntity implements Serializable {
    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 资源id
     */
    private Long permissionId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}