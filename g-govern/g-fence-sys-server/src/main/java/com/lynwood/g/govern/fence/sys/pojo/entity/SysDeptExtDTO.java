package com.lynwood.g.govern.fence.sys.pojo.entity;

import java.util.Date;

public class SysDeptExtDTO {
    /**
     * 部门ID
     */
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

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public void setDeptName(java.lang.String deptName) {
        this.deptName = deptName;
    }

    public void setFId(java.lang.Long fId) {
        this.fId = fId;
    }

    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setCreateBy(java.lang.Long createBy) {
        this.createBy = createBy;
    }

    public void setUpdateBy(java.lang.Long updateBy) {
        this.updateBy = updateBy;
    }

    public java.lang.Long getId() {
        return this.id;
    }

    public java.lang.String getDeptName() {
        return this.deptName;
    }

    public java.lang.Long getFId() {
        return this.fId;
    }

    public java.util.Date getCreateTime() {
        return this.createTime;
    }

    public java.util.Date getUpdateTime() {
        return this.updateTime;
    }

    public java.lang.Long getCreateBy() {
        return this.createBy;
    }

    public java.lang.Long getUpdateBy() {
        return this.updateBy;
    }
}