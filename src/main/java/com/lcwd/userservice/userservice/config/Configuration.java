package com.lcwd.userservice.userservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    @LoadBalanced//to enable the service name instead of localhost and port in the api call
   public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
