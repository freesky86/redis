package com.example.redis.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisHashExample {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private HashOperations<String, String, String> hashOps;

    @PostConstruct
    public void init() {
        hashOps = stringRedisTemplate.opsForHash();
    }

    public void setHash(String key, String hashKey, String value) {
        hashOps.put(key, hashKey, value);
    }

    public String getHash(String key, String hashKey) {
        return hashOps.get(key, hashKey);
    }
}