package com.zzd.authdemo.expression;

import com.zzd.authdemo.config.SecurityConfig;
import com.zzd.authdemo.domain.LoginUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * @author :zzd
 * @date : 2022/11/6
 */
@Component("ex")
public class SGExpressionRoot {
    public boolean hasAuthority(String authority) {
        //获取当前登录权限
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        List<String> permissions = loginUser.getPermissions();
        return permissions.contains(authority);

    }
}
