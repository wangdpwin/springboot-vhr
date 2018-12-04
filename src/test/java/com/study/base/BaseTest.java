package com.study.base;

import com.study.annotations.bean.User;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.junit.Test;

public class BaseTest {

    @Test
    public void addUser(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("1234");
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUsername(),user.getPassword());
        System.out.println(token.toString());
    }

}
