package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository {

    @Autowired
    private RedisTemplate<String, HospitalData> redisTemplate;

    private final String hashReference= "hospitalData";

    @Override
    public void save(String id, HospitalData value) {
        redisTemplate.opsForValue().set(hashReference, value);
    }

    @Override
    public Optional<HospitalData> find(String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(hashReference));
    }

}
