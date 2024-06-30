package com.example.product_service_24.configuartions;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfig  {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
