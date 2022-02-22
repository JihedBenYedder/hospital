package com.alpha.hospital.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConfiguration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import java.time.Duration;

@Configuration
@EnableRedisRepositories({
        "com.alpha.hospital.configuration"
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
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisProperties redisProperties) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory(redisProperties));
        return template;
    }


}
