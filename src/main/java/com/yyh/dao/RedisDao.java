package com.yyh.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.JedisPool;

import java.util.Set;

/**
 * @author YanYuHang
 * @create 2019-12-20-10:46
 */
@Repository
public class RedisDao {

    @Autowired
    private JedisPool jp;

    /**
     * 获取方法
     *
     * @param key
     * @return
     */
    public String get(String key) {
        return jp.getResource().get(key);
    }


    public String set(String key, String value) {
        return jp.getResource().set(key, value);
    }


    public String hget(String hkey, String key) {
        return jp.getResource().hget(hkey, key);
    }

    public long hset(String hkey, String key, String value) {
        return jp.getResource().hset(hkey, key, value);
    }

    public Set<String> getAllKeys(){
        return jp.getResource().keys("student_*");
    }

}
