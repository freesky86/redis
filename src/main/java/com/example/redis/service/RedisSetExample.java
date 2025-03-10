package com.example.redis.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class RedisSetExample {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private SetOperations<String, String> setOps;

    @PostConstruct
    public void init() {
        setOps = stringRedisTemplate.opsForSet();
    }

    public void addToSet(String key, String value) {
        setOps.add(key, value);
    }

    public boolean isMember(String key, String value) {
        return setOps.isMember(key, value);
    }

    public Set<String> getAllMembers(String key) {
        return setOps.members(key);
    }

    public String randomMember(String key) {
        return setOps.randomMember(key);
    }
}
