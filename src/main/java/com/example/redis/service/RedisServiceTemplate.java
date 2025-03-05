package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceTemplate {
    // 自动注入 RedisTemplate
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 自动注入 StringRedisTemplate
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    // 使用 StringRedisTemplate 操作字符串
    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    // 删除键
    public void deleteKey(String key) {
        redisTemplate.delete(key);
        stringRedisTemplate.delete(key);
    }
}
