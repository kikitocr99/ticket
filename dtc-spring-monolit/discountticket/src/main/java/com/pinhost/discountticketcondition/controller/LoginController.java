package com.pinhost.discountticketcondition.controller;

import com.pinhost.discountticketcondition.services.CustomerService;
import com.pinhost.discountticketcondition.services.DiscountTicketService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import com.pinhost.mm.dtcdatabase.repositories.CustomerRepositoryH2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/index")
public class LoginController {

    private static final Log LOG = LogFactory.getLog(LoginController.class);

    private CustomerRepositoryH2 customerRepositoryH2;

    @Autowired
    private DiscountTicketService discountTicketService;

    @Autowired
    private CustomerService customerService;

    public LoginController() {
        this.customerRepositoryH2 = new CustomerRepositoryH2();
    }

    @GetMapping
    public @ResponseBody
    List<DiscountTicketCondition> getIndex(Authentication authentication) {
        //User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (authentication != null) {
            LOG.info("Este es el Username: ".concat(authentication.getName()));
            com.pinhost.mm.dtcdatabase.model.Customer customer = customerService.getCustomerByUserName(authentication.getName());
            return discountTicketService.getDTCList(customer.getId());
        }
        return null;
    }

    @GetMapping("/rest/{id}")
    public @ResponseBody
    Customer getCustomerById(@PathVariable("id") final Integer id) {
        return customerRepositoryH2.getCustomerById(id);
    }

}
