package com.pinhost.mm.userservice.component;

import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import com.pinhost.mm.userservice.model.DiscountList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class DiscountTicketClient {
    @Autowired
    private RestTemplate restTemplate;

    private String catalogServiceHost;

    private long catalogServicePort;

    @Autowired
    public DiscountTicketClient(@Value("${catalog.service.host:localhost}") String catalogServiceHost,
                         @Value("${catalog.service.port:8001}") long catalogServicePort) {
        super();
        this.catalogServiceHost = catalogServiceHost;
        this.catalogServicePort = catalogServicePort;
    }

    private String getURL() {
        String url = String.format("http://%s:%s/ticket/", catalogServiceHost, catalogServicePort);
        return url;
    }

    public DiscountTicketCondition getOne(String name) {
        return restTemplate.getForObject(getURL() + name, DiscountTicketCondition.class);
    }

    public List<DiscountTicketCondition> getAll(Long userId){
        /*ResponseEntity<List<DiscountTicketCondiction>> response = restTemplate.exchange(getURL()  + userId,
                                                                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DiscountTicketCondiction>>(){});
        List<DiscountTicketCondiction> list = response.getBody();*/
        DiscountList response = restTemplate.getForObject(getURL() + userId, DiscountList.class);
        return response.getDiscountTicketCondictions();
        /*DiscountTicketCondiction[] response = restTemplate.getForObject(getURL() + userId, DiscountTicketCondiction[].class);
        return Arrays.asList(response);*/
    }
}
