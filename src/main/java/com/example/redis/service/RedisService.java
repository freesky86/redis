package com.example.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    // 设置值
    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    // 获取值
    public String getValue(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    // 删除值
    public void deleteValue(String key) {
        redisTemplate.delete(key);
    }
}
