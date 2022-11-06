package com.zzd.authdemo.service;

import com.zzd.authdemo.domain.ResponseResult;
import com.zzd.authdemo.domain.User;

/**
 * @author :zzd
 * @date : 2022/11/4
 */
public interface LoginService {
    public ResponseResult login(User user);

    ResponseResult logout();

}
