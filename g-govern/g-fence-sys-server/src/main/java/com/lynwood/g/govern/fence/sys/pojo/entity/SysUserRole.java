package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户和角色关联表
 * @TableName sys_user_role
 */
@TableName(value ="sys_user_role")
@Data
public class SysUserRole extends GBaseEntity implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 角色ID
     */
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}