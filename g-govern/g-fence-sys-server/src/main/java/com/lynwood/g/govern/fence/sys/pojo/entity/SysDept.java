package com.lynwood.g.govern.fence.sys.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lynwood.g.base.rock.mybatis.GBaseEntity;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门表
 * @TableName sys_dept
 */
@TableName(value ="sys_dept")
@Data
public class SysDept extends GBaseEntity implements Serializable {
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


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}