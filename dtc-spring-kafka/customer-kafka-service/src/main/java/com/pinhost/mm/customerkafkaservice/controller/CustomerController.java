package com.pinhost.mm.customerkafkaservice.controller;

import com.pinhost.mm.customerkafkaservice.service.CustomerService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private KafkaTemplate<String, Customer> kafkaTemplate;

    @GetMapping("/{name}")
    public com.pinhost.mm.dtcdatabase.model.Customer getCustomer(@PathVariable("name") final String name) {
        com.pinhost.mm.dtcdatabase.model.Customer c = customerService.getCustomer(name);
        kafkaTemplate.send("mm.user", c.getId() + "created", c);
        return c;
    }
}
