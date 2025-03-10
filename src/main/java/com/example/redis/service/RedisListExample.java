package com.example.redis.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisListExample {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ListOperations<String, String> listOps;

    @PostConstruct
    public void init() {
        listOps = stringRedisTemplate.opsForList();
    }

    public void pushToList(String key, String value) {
        listOps.leftPush(key, value);
    }

    public String popFromList(String key) {
        return listOps.rightPop(key);
    }
}