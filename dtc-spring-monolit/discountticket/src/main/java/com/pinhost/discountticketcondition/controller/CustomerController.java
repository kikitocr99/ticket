package com.pinhost.discountticketcondition.controller;

import com.pinhost.discountticketcondition.services.CustomerService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/customer")
@PreAuthorize("hasRole('ROLE_DiscountTicket')")
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    private static final Log LOG = LogFactory.getLog(CustomerController.class);


    @GetMapping("/{name}")
    public com.pinhost.mm.dtcdatabase.model.Customer getCustomer(@PathVariable("name") final String name) {
        return customerService.getCustomer(name);
    }

    @GetMapping("/by/{id}")
    public com.pinhost.mm.dtcdatabase.model.Customer getCustomerById(@PathVariable("id") final Integer id) {
        com.pinhost.mm.dtcdatabase.model.Customer c = customerService.getCustomerById(id);
        LOG.info("Customer wurde gesendet: ".concat(c.toString()));
        return c;
    }

    @GetMapping("/by/username/{username}")
    public Customer getCustomerByUserName(@PathVariable("username") final String userName) {
        return customerService.getCustomerByUserName(userName);
    }
    @GetMapping("/hello")
    public String getHello(){
        return "Hallo World";
    }
}
