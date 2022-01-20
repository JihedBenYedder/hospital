package com.alpha.hospital.model.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.TimeZone;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository {

    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;

    @Override
    public Mono save(String id, String value) {
        return reactiveRedisTemplate.opsForValue().set(id, value);
    }

    @Override
    public Mono<String> find(String id) {
        return reactiveRedisTemplate.opsForValue().get(id);
    }

    @Override
    public void delete(String id) {
            reactiveRedisTemplate.opsForValue().delete(id);
    }
}
