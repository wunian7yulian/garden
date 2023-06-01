package com.lynwood.g.govern.fence.sys.controller;

import com.lynwood.g.base.rock.web.utils.AssertUtil;
import com.lynwood.g.base.soi.common.enums.ResultCode;
import com.lynwood.g.base.soi.common.model.R;
import com.lynwood.g.govern.fence.sys.dto.UserAuthDTO;
import com.lynwood.g.govern.fence.sys.feign.UserFeignClient;
import com.lynwood.g.govern.fence.sys.pojo.entity.SysUser;
import com.lynwood.g.govern.fence.sys.service.SysUserRoleService;
import com.lynwood.g.govern.fence.sys.service.SysUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * @author： Lynwood
 */
@Slf4j
@AllArgsConstructor
@RestController
public class UserController implements UserFeignClient {

    private final SysUserService sysUserService;

    private final SysUserRoleService sysUserRoleService;


    @Override
    public R<UserAuthDTO> getUserByUsername(String username) {
        UserAuthDTO userAuthDTO = new UserAuthDTO();
        AssertUtil.notEmpty(userAuthDTO, ResultCode.USER_NOT_EXIST);
        SysUser sysUser = sysUserService.getUserByUserName(username);
        userAuthDTO.setUsername(sysUser.getUsername());
        userAuthDTO.setUserId(sysUser.getId());
        userAuthDTO.setPassword(sysUser.getPassword());
        userAuthDTO.setNickname(sysUser.getNickname());
        userAuthDTO.setStatus(sysUser.getStatus());
        Set<String> roleCodeList = sysUserRoleService.getRoleCodeListByUserId(sysUser.getId());
        userAuthDTO.setRoles(roleCodeList);
        return R.ok(userAuthDTO);
    }
}
