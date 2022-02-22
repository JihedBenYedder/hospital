package com.alpha.hospital.model.repository;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

@Repository
public class HospitalRepositoryImpl implements HospitalRepository {



    @Bean
    public ReactiveRedisTemplate<String, HospitalData> reactiveRedisTemplate(
            ReactiveRedisConnectionFactory factory) {
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        Jackson2JsonRedisSerializer<HospitalData> valueSerializer =
                new Jackson2JsonRedisSerializer<>(HospitalData.class);
        RedisSerializationContext.RedisSerializationContextBuilder<String, HospitalData> builder =
                RedisSerializationContext.newSerializationContext(keySerializer);
        RedisSerializationContext<String, HospitalData> context =
                builder.value(valueSerializer).build();
        return new ReactiveRedisTemplate<>(factory, context);
    }

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
