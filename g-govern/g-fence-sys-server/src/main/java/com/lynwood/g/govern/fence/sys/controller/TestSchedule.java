package com.lynwood.g.govern.fence.sys.controller;

import com.lynwood.g.govern.fence.sys.service.SysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author Lynwood
 * @Date 2023/5/24
 * @Version 1.0
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TestSchedule {


    private final SysUserService sysUserService;
    //@Scheduled(cron ="* * * * * ? ")
    private void test(){
        log.info(sysUserService.getUserByUserName("zhangsan@qq.com").getNickname());
    }
}
