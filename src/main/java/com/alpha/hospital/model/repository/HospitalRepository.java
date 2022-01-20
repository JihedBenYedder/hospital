package com.alpha.hospital.model.repository;

import reactor.core.publisher.Mono;

import java.util.Optional;

public interface HospitalRepository {
    Mono save(String id, String value);
    Mono<String> find(String id);
    void delete(String id);
}
