package com.study.base;

import com.study.model.User;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;

public class HashCredit {

    /**
     * 密码加密算法
     * password:明文密码，mysql中保存为加密后密码
     * salt：盐，系统中使用账号username
     * hashCount：散列次数，如2次表示：md5(md5(str))：“new Md5Hash(str, salt, 2).toString()”
     */
    @Test
    public void getPassword(){
        String password = "123456";
        String salt = "admin";
        int hashCount = 2;
        String md5Password = new Md5Hash(password, salt, hashCount).toString();
        System.out.println(md5Password);
    }

    /**
     * 重置密码
     */
    @Test
    public void resetPassword(){
        String password = "123456";
        String salt = "admin";
        int hashCount = 2;
        String md5Password = new Md5Hash(password, salt, hashCount).toString();
        System.out.println(md5Password);
    }

    /**
     * 创建用户
     */
    @Test
    public void saveUser(){
        String username = "test";
        String password = "123456";
        String salt = username;
        int hashCount = 2;
        String md5Password = new Md5Hash(password, salt, hashCount).toString();
        User user =new User();
        user.setUsername(username);
        user.setPassword(md5Password);
        user.setEnable(1);
//        user.save();
    }

}
