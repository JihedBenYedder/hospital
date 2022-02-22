package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Optional;

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
    public <S extends String> S save(S entity) {
        return null;
    }

    @Override
    public <S extends String> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<String> findById(HospitalData hospitalData) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(HospitalData hospitalData) {
        return false;
    }

    @Override
    public Iterable<String> findAll() {
        return null;
    }

    @Override
    public Iterable<String> findAllById(Iterable<HospitalData> hospitalData) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(HospitalData hospitalData) {

    }

    @Override
    public void delete(String id) {
            reactiveRedisTemplate.opsForValue().delete(id);
    }

    @Override
    public void deleteAllById(Iterable<? extends HospitalData> hospitalData) {

    }

    @Override
    public void deleteAll(Iterable<? extends String> entities) {

    }

    @Override
    public void deleteAll() {
        reactiveRedisTemplate.opsForValue().delete("hospitalData");
    }
}
