package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class LettuceController {

    @Autowired
    private ReactiveRedisTemplate reactiveRedisTemplate;

    @PutMapping("/put")
    public Mono put(@RequestParam("key") String key, @RequestParam("val") String val) {
        return reactiveRedisTemplate.opsForValue().set(key, val);
    }

    @GetMapping("/get")
    public Mono<String> get(@RequestParam("key") String key) {
        return reactiveRedisTemplate.opsForValue().get(key);
    }

    @GetMapping("/addList")
    public Mono<Long> addList(@RequestParam("key") String key, @RequestParam("val") String val) {
        return reactiveRedisTemplate.opsForList().rightPush(key, val);
    }

}