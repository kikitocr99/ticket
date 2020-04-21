package com.pinhost.mm.startdiscount.controller;

import com.pinhost.mm.startdiscount.component.CustomerClient;
import com.pinhost.mm.startdiscount.model.Customer;
import com.pinhost.mm.startdiscount.model.DiscountTicketCondition;
import com.pinhost.mm.startdiscount.service.DiscountTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class DiscountTicketController {
    @Autowired
    private DiscountTicketService discountTicketService;

    @Autowired
    private CustomerClient customerClient;

    @GetMapping("/{name}")
    public DiscountTicketCondition getDTCByName(@PathVariable("name") final String name) {
        return discountTicketService.getDTCByName(name);
    }

    @GetMapping("/by/id/{id}")
    public List<DiscountTicketCondition> getDtcList(@PathVariable("id") final Integer customerId) {
        return discountTicketService.getDTCList(customerId);
    }

    @GetMapping("/customer/by/name/{name}")
    public long getCustomerId(@PathVariable("name") final String name){
        return customerClient.getCustomerName(name);
    }

    @GetMapping("/all/{userid}")
    public List<DiscountTicketCondition> getAllByUserId(@PathVariable("userid") final Long userId){
        System.out.println("quiero ver..........");
        Customer customerId = customerClient.getCustomerByUserId(userId);
        System.out.println("Entro aquiii " + customerId);
        return discountTicketService.getDTCList(customerId.getId());
    }

}
