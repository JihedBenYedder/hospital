package com.alpha.hospital.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("redis")
public class RedisProperties {

    private int port;
    private String host;

    //Not used but kept in case of future use
    private String password;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
