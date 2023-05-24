package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 部门表
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
@Data
public class SysDept implements Serializable {
    /**
     * 部门ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 父级id
     */
    private Long fId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 修改人
     */
    private Long updateBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}