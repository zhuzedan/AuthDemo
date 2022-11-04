package com.zzd.authdemo.controller;

import com.zzd.authdemo.domain.ResponseResult;
import com.zzd.authdemo.domain.User;
import com.zzd.authdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zzd
 * @date : 2022/11/4
 */
@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){

        return loginService.login(user);
    }

}
