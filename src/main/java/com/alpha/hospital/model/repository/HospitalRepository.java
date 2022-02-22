package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.data.repository.CrudRepository;
import reactor.core.publisher.Mono;


public interface HospitalRepository extends CrudRepository<String, HospitalData> {

    Mono<Boolean> save(String id, HospitalData value);
    Mono<HospitalData> find(String id);
    void delete(String id);

}
