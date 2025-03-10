package com.example.redis.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisExampleTests {

    @Autowired
    private RedisStringExample redisStringExample;

    @Autowired
    private RedisHashExample redisHashExample;

    @Autowired
    private RedisListExample redisListExample;

    @Autowired
    private RedisSetExample redisSetExample;

    @Autowired
    private RedisSortedSetExample redisSortedSetExample;

    @Test
    public void testRedisOperations() {
        // String
        redisStringExample.setString("myKey", "myValue");
        System.out.println(redisStringExample.getString("myKey"));

        // Hash
        redisHashExample.setHash("myHash", "hashKey", "hashValue");
        System.out.println(redisHashExample.getHash("myHash", "hashKey"));

        // List
        redisListExample.pushToList("myList", "listValue1");
        redisListExample.pushToList("myList", "listValue2");
        System.out.println(redisListExample.popFromList("myList"));
        System.out.println(redisListExample.popFromList("myList"));

        // Set
        redisSetExample.addToSet("mySet", "setValue1");
        System.out.println(redisSetExample.isMember("mySet", "setValue1"));

        // Sorted Set
        redisSortedSetExample.addToSortedSet("mySortedSet", "sortedValue1", 1.0);
        System.out.println(redisSortedSetExample.getScore("mySortedSet", "sortedValue1"));
    }
}
