package com.pinhost.mm.startdiscount.component;

import com.pinhost.mm.startdiscount.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CustomerClient {

    @Autowired
    private RestTemplate restTemplate;

    public long getCustomerName(String name){
        return restTemplate.getForObject("http://localhost:8007/customer/test/" + name, Long.class);
        /*ResponseEntity<long> quoteResponse = restTemplate.exchange("http://localhost:8083/rest/db/" + username, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<String>>() {
                });

        List<long> quotes = quoteResponse.getBody();
        return quotes;*/
    }
    public Customer getCustomerByUserId(Long userId){
        return restTemplate.getForObject("http://localhost:8007/customer/by/username/" + userId, Customer.class);
    }

}
