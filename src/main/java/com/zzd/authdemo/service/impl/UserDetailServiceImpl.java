package com.zzd.authdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzd.authdemo.dao.MenuMapper;
import com.zzd.authdemo.dao.UserMapper;
import com.zzd.authdemo.domain.LoginUser;
import com.zzd.authdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author :zzd
 * @date : 2022/11/4
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名获取数据库中的用户
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUserName,username);
        User user = userMapper.selectOne(lambdaQueryWrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名错误！");
        }
        // //TODO 权限信息 假数据
        // List<String> list = new ArrayList<>(Arrays.asList("hello","delgoods"));
        List<String> perms = menuMapper.selectPermsByUserId(user.getId());
        //返回userdetails

        return new LoginUser(user,perms);
    }
}
