package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository {

    @Resource(name="redisTemplate")
    private HashOperations<String, Integer, HospitalData> hashOperations;

    private final String hashReference= "hospitalData";

    @Override
    public void save(String id, HospitalData value) {
        hashOperations.putIfAbsent(hashReference, 1, value);
    }

    @Override
    public HospitalData find(String id) {
        return hashOperations.get(id,hashReference);
    }

}
