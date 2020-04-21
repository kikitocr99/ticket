package com.pinhost.mm.userservice.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate getRestTemplate(){
       /* RestTemplate restTemplate = new RestTemplate();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new ObjectMapper());
        restTemplate.getMessageConverters().add(converter);
        return restTemplate;*/

        return new RestTemplate();
        /*return restTemplateBuilder.requestFactory(this.clientHttpRequestFactory())
                .messageConverters(new MappingJackson2HttpMessageConverter())
                .basicAuthentication("lnaranjo", "Test").build();*/
    }
    /*@Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(1000);
        clientHttpRequestFactory.setReadTimeout(1000);
        clientHttpRequestFactory.setBufferRequestBody(false);
        return clientHttpRequestFactory;
    }*/

    @Bean
    public RestTemplateBuilder getRestBuild(){
        return new RestTemplateBuilder();
    }
}
