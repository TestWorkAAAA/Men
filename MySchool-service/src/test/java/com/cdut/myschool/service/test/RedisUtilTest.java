package com.MySchool.myschool.service.test;

import org.junit.Assert;
import org.junit.Test;


public class RedisUtilTest
{
    @Test
    public void redisTest(){
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.initJedisPool();
        redisUtil.hset("123456", "1", "dengyu");
        redisUtil.listRightPush("12345", "dengyu");
        String vString = (String)redisUtil.hget("123456", "1");
        boolean flag = redisUtil.exists("123456");
        Assert.assertEquals("dengyu", vString);
    }
}
