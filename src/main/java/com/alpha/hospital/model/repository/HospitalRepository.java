package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.Optional;


public interface HospitalRepository {

    void save(String id, HospitalData value);
    Optional<HospitalData> find(String id);
}
