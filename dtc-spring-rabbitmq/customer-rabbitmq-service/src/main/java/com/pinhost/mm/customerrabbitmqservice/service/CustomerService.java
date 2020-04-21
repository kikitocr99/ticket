package com.pinhost.mm.customerrabbitmqservice.service;

import com.pinhost.mm.dtcdatabase.repositories.CustomerRepositoryH2;
import com.pinhost.mm.dtcdatabase.repositories.UserRepositoryH2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private static final Log LOG = LogFactory.getLog(CustomerService.class);

    private UserRepositoryH2 userRepositoryH2;

    private CustomerRepositoryH2 customerRepositoryH2;

    @Autowired
    public CustomerService() {
        this.userRepositoryH2 = new UserRepositoryH2();
        this.customerRepositoryH2 = new CustomerRepositoryH2();
    }

    public com.pinhost.mm.dtcdatabase.model.Customer getCustomer(String name) {
        com.pinhost.mm.dtcdatabase.model.Customer customer = customerRepositoryH2.getCustomerByName(name);
        if (customer != null) {
            return customer;
        }
        LOG.error("Der Customer wurde nicht gefunden.");
        return null;
    }
}
