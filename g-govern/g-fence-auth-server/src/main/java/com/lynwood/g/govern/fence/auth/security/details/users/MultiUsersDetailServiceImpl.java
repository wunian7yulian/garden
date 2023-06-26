package com.lynwood.g.govern.fence.auth.security.details.users;

import cn.hutool.core.util.StrUtil;
import com.lynwood.g.base.soi.common.constants.SecurityConstants;
import com.lynwood.g.govern.fence.auth.security.details.users.user.GUsersBaseDetails;
import com.lynwood.g.govern.fence.auth.security.enums.UserServerType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 多用户体系
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class MultiUsersDetailServiceImpl implements UserDetailsService {

    private Map<UserServerType,AbstractUserDetailService> userDetailServiceMap = new HashMap<>();

    @Autowired
    public MultiUsersDetailServiceImpl(List<AbstractUserDetailService> userDetailServiceList){
        for (AbstractUserDetailService userDetailService: userDetailServiceList) {
            userDetailServiceMap.put(userDetailService.getUserServerType(),userDetailService);
        }
    }


    @Override
    public GUsersBaseDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailServiceMap.get(getOAuth2UserServerType()).loadUserByUsername(username);
    }

    public static UserServerType getOAuth2UserServerType() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String basic = request.getHeader(SecurityConstants.G_BASIC_TOKEN);
        if (StrUtil.isNotBlank(basic) && basic.startsWith(SecurityConstants.G_BASIC_PREFIX)) {
            basic = basic.replace(SecurityConstants.G_BASIC_PREFIX, Strings.EMPTY);
            String basicPlainText = new String(Base64.getDecoder().decode(basic.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
            return UserServerType.getUserServerTypeByClient(basicPlainText);
        }
        return null;
    }
}
