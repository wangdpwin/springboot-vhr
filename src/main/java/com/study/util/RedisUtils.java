package com.study.util;


import javax.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * redis工具类
 */
public class RedisUtils {

    @Resource
    private static RedisTemplate<String,Object> redisTemplate;

    public static void save (String key,String value){

    }

}
