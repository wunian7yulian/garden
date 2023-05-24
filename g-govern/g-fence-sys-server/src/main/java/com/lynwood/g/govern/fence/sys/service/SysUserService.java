package com.lynwood.g.govern.fence.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

/**
 * @author wunian7yulian
 * @description 针对表【sys_user(用户信息表)】的数据库操作Service
 * @createDate 2023-05-24 10:41:39
 */
@CacheConfig(cacheNames = "redisCache")
public interface SysUserService extends IService<SysUser> {

    @CachePut(key = "'user_'+#result.id")
    SysUser getUserByUserName(String username);

    @CacheEvict(key = "'user_'+#user.id")
    void changeUser(SysUser user);
}
