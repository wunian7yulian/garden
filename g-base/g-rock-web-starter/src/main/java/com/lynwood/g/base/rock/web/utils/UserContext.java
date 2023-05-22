package com.lynwood.g.base.rock.web.utils;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lynwood.g.base.soi.common.enums.types.RoleType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import sun.security.util.SecurityConstants;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 只允许在api服务中使用
 *
 * @author： Lynwood
 */
public class UserContext {


    //public static Long getCurrentUserId() {
    //    String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(SecurityConstants.JWT_PAYLOAD_KEY);
    //    if (StringUtil.isEmpty(token)) {
    //        return null;
    //    }
    //    try {
    //        JSONObject jsonObject = JSON.parseObject(URLDecoder.decode(token, "utf-8"));
    //        if (Objects.isNull(jsonObject)) {
    //            return null;
    //        }
    //        return jsonObject.getLong("userId");
    //    } catch (UnsupportedEncodingException e) {
    //        e.printStackTrace();
    //    }
    //    return null;
    //}
    //
    ///**
    // * 获取昵称
    // * @return
    // */
    //public static String getCurrentNickName() {
    //    String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(SecurityConstants.JWT_PAYLOAD_KEY);
    //    if (StringUtil.isEmpty(token)) {
    //        return null;
    //    }
    //    try {
    //        JSONObject jsonObject = JSON.parseObject(URLDecoder.decode(token, "utf-8"));
    //        if (Objects.isNull(jsonObject)) {
    //            return null;
    //        }
    //        return jsonObject.getString("nickname");
    //    } catch (UnsupportedEncodingException e) {
    //        e.printStackTrace();
    //    }
    //    return null;
    //}
    //
    //
    //public static Set<String> getCurrentUserRoles() {
    //    String token = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader(SecurityConstants.JWT_PAYLOAD_KEY);
    //    if (StringUtil.isEmpty(token)) {
    //        return null;
    //    }
    //    try {
    //        JSONObject jsonObject = JSON.parseObject(URLDecoder.decode(token, "utf-8"));
    //        if (Objects.isNull(jsonObject)) {
    //            return null;
    //        }
    //        Set<String> authoritieSet = new HashSet<>();
    //        jsonObject.getJSONArray("authorities").forEach(item->{
    //            authoritieSet.add((String) item);
    //            });
    //        return authoritieSet;
    //    } catch (UnsupportedEncodingException e) {
    //        e.printStackTrace();
    //    }
    //    return null;
    //}
    //
    //public static boolean isHaveRoleType(RoleType roleType) {
    //    Set<String> currentUserRoles = UserContext.getCurrentUserRoles();
    //    for(String roleCode : currentUserRoles){
    //        if(roleType.equals(RoleType.getRoleType(roleCode))){
    //            return true;
    //        }
    //    }
    //    return false;
    //}
}
