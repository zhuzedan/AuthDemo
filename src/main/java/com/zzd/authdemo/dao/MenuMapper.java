package com.zzd.authdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzd.authdemo.domain.Menu;

import java.util.List;

/**
 * @author :zzd
 * @date : 2022/11/6
 */
public interface MenuMapper extends BaseMapper<Menu> {
    List<String> selectPermsByUserId(Long userId);
}
