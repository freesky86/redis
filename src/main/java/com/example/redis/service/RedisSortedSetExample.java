package com.example.redis.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;


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

    public Set<String> rangeByScore(String key, double min, double max) {
        return zSetOps.rangeByScore(key, min, max);
    }

    public Set<String> range(String key, long start, long end) {
        return zSetOps.range(key, start, end);
    }

    public Set<ZSetOperations.TypedTuple<String>> rangeByScoreWithScores(String key, double min, double max) {
        return zSetOps.rangeByScoreWithScores(key, min, max);
    }

    public String getMaxScoreMember(String key) {
        // 获取 score 最大的成员
        Set<String> members = zSetOps.reverseRange(key, 0, 0);
        return members != null && !members.isEmpty() ? members.iterator().next() : null;
    }

    public String getMaxScoreMemberWithScore(String key) {
        // 获取 score 最大的成员及其 score
        Set<ZSetOperations.TypedTuple<String>> tuples = zSetOps.reverseRangeWithScores(key, 0, 0);
        if (tuples != null && !tuples.isEmpty()) {
            ZSetOperations.TypedTuple<String> tuple = tuples.iterator().next();
            return tuple.getValue() + " : " + tuple.getScore();
        }
        return null;
    }

}
