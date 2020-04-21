package com.pinhost.mm.customerrabbitmqservice.controller;

import com.pinhost.mm.customerrabbitmqservice.service.CustomerService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    private static final Log LOG = LogFactory.getLog(CustomerController.class);


    @GetMapping("/{name}")
    public com.pinhost.mm.dtcdatabase.model.Customer getCustomer(@PathVariable("name") final String name) {
        Customer customer = customerService.getCustomer(name);
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.customer", customer);
        LOG.info("Is listener returned ::: "+rabbitTemplate.isReturnListener());
        return customer;
    }

}
