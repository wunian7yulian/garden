package com.lynwood.g.govern.fence.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysUser;
import com.lynwood.g.govern.fence.sys.service.SysUserService;
import com.lynwood.g.govern.fence.sys.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author wunian7yulian
* @description 针对表【sys_user(用户信息表)】的数据库操作Service实现
* @createDate 2023-05-24 10:41:39
*/
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser>
    implements SysUserService{

    @Override
    public SysUser getUserByUserName(String username) {
        SysUser sysUser = new SysUser();
        sysUser.setId(1L);
        sysUser.setNickname("张三");
        log.info("1");
        return sysUser;
    }

    @Override
    public void changeUser(SysUser user) {
        log.info("changed!");
    }
}




