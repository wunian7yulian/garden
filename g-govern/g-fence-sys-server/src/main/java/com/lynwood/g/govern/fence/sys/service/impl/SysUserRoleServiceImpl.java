package com.lynwood.g.govern.fence.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lynwood.g.govern.fence.sys.mapper.SysRoleMapper;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysRole;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysUserRole;
import com.lynwood.g.govern.fence.sys.service.SysRoleService;
import com.lynwood.g.govern.fence.sys.service.SysUserRoleService;
import com.lynwood.g.govern.fence.sys.mapper.SysUserRoleMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
* @author wunian7yulian
* @description 针对表【sys_user_role(用户和角色关联表)】的数据库操作Service实现
* @createDate 2023-05-24 18:51:41
*/
@Service
@AllArgsConstructor
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole>
    implements SysUserRoleService{

    private final SysRoleMapper sysRoleMapper;


    @Override
    public Set<String> getRoleCodeListByUserId(Long userId) {

        List<SysUserRole> sysUserRoles = baseMapper.selectList(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getUserId, userId));

        List<SysRole> sysRoles = sysRoleMapper.selectList(new LambdaQueryWrapper<SysRole>().in(SysRole::getId, sysUserRoles.stream().map(SysUserRole::getRoleId).collect(Collectors.toSet())));
        return sysRoles.stream().map(SysRole::getCode).collect(Collectors.toSet());
    }
}




