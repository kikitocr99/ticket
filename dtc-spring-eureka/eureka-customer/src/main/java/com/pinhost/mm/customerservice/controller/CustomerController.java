package com.pinhost.mm.customerservice.controller;

import com.pinhost.mm.customerservice.model.Customer;
import com.pinhost.mm.customerservice.service.CustomerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Log LOG = LogFactory.getLog(CustomerController.class);

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{name}")
    public Customer getCustomer(@PathVariable("name") final String name) {
        return customerService.getCustomer(name);
    }

    @GetMapping("/test/{name}")
    public long getCustomerId(@PathVariable("name") final String name){
        Customer customer = customerService.getCustomer(name);
        return customer.getId();
    }

    @GetMapping("/by/{id}")
    public Customer getCustomerById(@PathVariable("id") final Integer id) {
        Customer c = customerService.getCustomerById(id);
        LOG.info("Customer wurde gesendet: ".concat(c.toString()));
        return c;
    }

    @GetMapping("/by/username/{userid}")
    public Customer getCustomerByUserName(@PathVariable("useuseridrname") final Long userId) {
        return customerService.getCustomerByUserId(userId);
    }
}
