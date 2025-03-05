package com.example.redis.controller;

import com.example.redis.service.RedisServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis2")
public class RedisControllerTemplate {

    @Autowired
    private RedisServiceTemplate redisService;

    @PostMapping("/set")
    public String setString(@RequestParam String key, @RequestParam String value) {
        redisService.setString(key, value);
        return "Value set successfully!";
    }

    @GetMapping("/get")
    public String getString(@RequestParam String key) {
        return redisService.getString(key);
    }

    @DeleteMapping("/delete")
    public String deleteKey(@RequestParam String key) {
        redisService.deleteKey(key);
        return "Value deleted successfully!";
    }
}
