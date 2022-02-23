package com.alpha.hospital.configuration;

import com.alpha.hospital.model.dto.HospitalData;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories({
        "com.alpha.hospital.model.repository"
})
@EnableConfigurationProperties(RedisProperties.class)
public class JedisConfiguration {
/*
    @Bean
    @Primary
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory(RedisConfiguration defaultRedisConfig) {
        LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder()
                //Do not use SSL for local testing
                .useSsl().and()
                .commandTimeout(Duration.ofMillis(60000)).build();
        return new LettuceConnectionFactory(defaultRedisConfig, clientConfig);
    }

    @Bean
    public RedisConfiguration defaultRedisConfig(RedisProperties redisProperties) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisProperties.getHost());
        config.setPassword(RedisPassword.of(redisProperties.getPassword()));
        return config;
    }*/

    @Bean
    JedisConnectionFactory jedisConnectionFactory(RedisProperties redisProperties) {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisProperties.getHost(), 6379);
        redisStandaloneConfiguration.setPassword(redisProperties.getPassword());
        JedisConnectionFactory cnxFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        cnxFactory.getPoolConfig().setMaxIdle(30);
        cnxFactory.getPoolConfig().setMinIdle(10);
        return cnxFactory;
    }

    @Bean
    public RedisTemplate<String, HospitalData> redisTemplate(@Qualifier("jedisConnectionFactory") final JedisConnectionFactory jedisConnectionFactory) {
        RedisTemplate<String, HospitalData> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory);
        return template;
    }


}
