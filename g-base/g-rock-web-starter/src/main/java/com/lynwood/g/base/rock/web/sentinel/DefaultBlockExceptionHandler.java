package com.lynwood.g.base.rock.web.sentinel;

import cn.hutool.http.HttpStatus;
import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author： Lynwood
 */
@Component
public class DefaultBlockExceptionHandler implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        response.setStatus(HttpStatus.HTTP_OK);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        ObjectMapper objectMapper = new ObjectMapper();
        //
        //// 流控
        //if (e instanceof FlowException) {
        //    objectMapper.writeValue(response.getWriter(), R.failed(ResultCode.SYS_FLOW_LIMITING));
        //    // 降级
        //} else if (e instanceof DegradeException) {
        //    objectMapper.writeValue(response.getWriter(), R.failed(ResultCode.SYS_DEGRADATION));
        //    // 未授权
        //}
    }
}
