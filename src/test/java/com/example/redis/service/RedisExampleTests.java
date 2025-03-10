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
        redisSetExample.addToSet("mySet", "setValue2");
        redisSetExample.addToSet("mySet", "setValue3");
        redisSetExample.addToSet("mySet", "setValue4");
        redisSetExample.addToSet("mySet", "setValue5");
        System.out.println(redisSetExample.isMember("mySet", "setValue1"));
        System.out.println(redisSetExample.getAllMembers("mySet"));
        System.out.println(redisSetExample.randomMember("mySet"));

        // Sorted Set
        redisSortedSetExample.addToSortedSet("mySortedSet", "sortedValue1", 1.0);
        redisSortedSetExample.addToSortedSet("mySortedSet", "sortedValue2", 2.0);
        redisSortedSetExample.addToSortedSet("mySortedSet", "sortedValue3", 3.0);
        System.out.println(redisSortedSetExample.getScore("mySortedSet", "sortedValue1"));
        System.out.println(redisSortedSetExample.rangeByScore("mySortedSet", 1.0, 2.0));
        System.out.println(redisSortedSetExample.rangeByScoreWithScores("mySortedSet", 1.0, 2.0));
        System.out.println(redisSortedSetExample.range("mySortedSet", 0, -1));
        System.out.println(redisSortedSetExample.range("mySortedSet", 0, 0));
        System.out.println(redisSortedSetExample.getMaxScoreMember("mySortedSet"));
        System.out.println(redisSortedSetExample.getMaxScoreMemberWithScore("mySortedSet"));
    }
}
