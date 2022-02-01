package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import reactor.core.publisher.Mono;


public interface HospitalRepository {

    Mono save(String id, HospitalData value);
    Mono<HospitalData> find(String id);
    void delete(String id);

}
