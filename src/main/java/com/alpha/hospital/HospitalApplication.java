package com.alpha.hospital;

import com.alpha.hospital.configuration.RedisProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages =  {"com.alpha.hospital"})
@EnableConfigurationProperties(RedisProperties.class)
public class HospitalApplication {

	public static void main(String[] args, RedisProperties redisProperties) {
		SpringApplication.run(HospitalApplication.class, args);
		System.out.println("password is"+ redisProperties.getPassword());
	}

}
