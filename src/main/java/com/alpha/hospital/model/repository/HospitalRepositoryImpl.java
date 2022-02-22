package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository {

    @Resource
    private ReactiveRedisTemplate<String, HospitalData> reactiveRedisTemplate;

    @Override
    public Mono<Boolean> save(String id, HospitalData value) {
        System.out.println("saving : "+value.getOccupiedBedsNumber());
        return reactiveRedisTemplate.opsForValue().set("hospitalData", value);
    }

    @Override
    public Mono<HospitalData> find(String id) {
        return reactiveRedisTemplate.opsForValue().get(id);
    }

    @Override
    public void delete(String id) {
            reactiveRedisTemplate.opsForValue().delete(id);
    }
}
