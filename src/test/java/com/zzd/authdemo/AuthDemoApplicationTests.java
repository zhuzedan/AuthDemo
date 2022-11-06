package com.zzd.authdemo;

import com.zzd.authdemo.dao.MenuMapper;
import com.zzd.authdemo.dao.UserMapper;
import com.zzd.authdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class AuthDemoApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users.get(0));
    }
    @Autowired
    PasswordEncoder passwordEncoder;
    @Test
    public void bCrypt() {
        String ydlclass1 = passwordEncoder.encode("ydlclass");
        String ydlclass2 = passwordEncoder.encode("ydlclass");
        System.out.println(ydlclass1);
        System.out.println(ydlclass2);

        boolean ydlclass = passwordEncoder.matches("ydlclass", ydlclass1);
        System.out.println(ydlclass);
    }
    @Autowired
    MenuMapper menuMapper;
    @Test
    public void testSelectPermsByUserId() {
        List<String> strings = menuMapper.selectPermsByUserId(1L);
        System.out.println(strings);
    }

}
