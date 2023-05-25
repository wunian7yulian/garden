package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户和部门关联表
 * @TableName sys_user_dept
 */
@TableName(value ="sys_user_dept")
@Data
public class SysUserDept extends GBaseEntity implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 部门ID
     */
    private Long deptId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}