package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Optional;

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
    public Optional<HospitalData> find(String id) {
        return Optional.ofNullable(hashOperations.get(id,hashReference));
    }

}
