package com.lynwood.g.govern.fence.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lynwood.g.base.soi.common.configs.GardenBaseConfig;
import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.sys.mapper.SysDeptMapper;
import com.lynwood.g.govern.fence.sys.mapper.SysUserMapper;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysDept;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysUser;
import com.lynwood.g.govern.fence.sys.service.SysDeptService;
import com.lynwood.g.govern.fence.sys.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Lynwood
 * @Date 2023/5/24
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final SysUserMapper sysUserMapper;
    private final SysUserService sysUserService;

    private final SysDeptService sysDeptService;
    private final SysDeptMapper sysDeptMapper;
    private final GardenBaseConfig gardenBaseConfig;

    @GetMapping("/test")
    public R test() {
        Integer integer = sysUserMapper.selectCount(new QueryWrapper<>());
        log.info(">"+integer);
        return R.ok(gardenBaseConfig.getDomain());
    }

    @GetMapping("/get")
    public R get() {
        return R.ok(sysUserService.getUserByUserName("zhangsan"));
    }


    @GetMapping("/change")
    public R change() {
        SysUser sysUser = new SysUser();
        sysUser.setNickname("zhangsan");
        sysUser.setEmail("hh");
        sysUserService.changeUser(sysUser);
        return R.ok();
    }
    @GetMapping("/save")
    public R save() {
        SysUser sysUser = new SysUser();
        sysUser.setNickname("哈哈");
        sysUserService.save(sysUser);

        SysUser byId = sysUserService.getById(sysUser.getId());
        byId.setMobile("???");
        sysUserService.updateById(byId);
        //sysUserService.update(sysUser,null);
        //SysDept sysDept = new SysDept();
        //sysDept.setDeptName("11111");
        //sysDeptMapper.insert(sysDept);
        //sysDeptService.save(sysDept);
        return R.ok();
    }
}
