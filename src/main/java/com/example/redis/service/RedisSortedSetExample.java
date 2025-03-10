package com.example.redis.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisSortedSetExample {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ZSetOperations<String, String> zSetOps;

    @PostConstruct
    public void init() {
        zSetOps = stringRedisTemplate.opsForZSet();
    }

    public void addToSortedSet(String key, String value, double score) {
        zSetOps.add(key, value, score);
    }

    public Double getScore(String key, String value) {
        return zSetOps.score(key, value);
    }
}
