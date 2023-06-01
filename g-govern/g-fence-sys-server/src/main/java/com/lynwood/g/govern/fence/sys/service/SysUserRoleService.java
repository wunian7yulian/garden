package com.lynwood.g.govern.fence.sys.service;

import com.lynwood.g.govern.fence.sys.pojo.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Set;

/**
* @author wunian7yulian
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Service
* @createDate 2023-05-24 18:51:41
*/
public interface SysUserRoleService extends IService<SysUserRole> {

    Set<String> getRoleCodeListByUserId(Long userId);
}
