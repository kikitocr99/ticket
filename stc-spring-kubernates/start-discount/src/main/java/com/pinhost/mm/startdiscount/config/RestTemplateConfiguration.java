package com.pinhost.mm.startdiscount.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

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
}
