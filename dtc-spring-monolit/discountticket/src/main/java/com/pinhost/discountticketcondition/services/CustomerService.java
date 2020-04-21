package com.pinhost.discountticketcondition.services;

import com.pinhost.mm.dtcdatabase.model.Customer;
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

    public com.pinhost.mm.dtcdatabase.model.Customer getCustomerById(Integer id) {
        com.pinhost.mm.dtcdatabase.model.Customer customer = customerRepositoryH2.getCustomerById(id);
        if (customer != null) {
            return customer;
        }
        LOG.error("Der Customer mit dem Id " + id + " wurde nicht gefunden.");
        return null;
    }

    public Customer getCustomerByUserName(final String userName) {
        Long userId = userRepositoryH2.getUserIdByName(userName);
        if (userId != null) {
            return customerRepositoryH2.getCustomerByUserId(userId);
        }
        LOG.error("Es wurde keinen Customer mit diesem id gefunden. PARAMS: ".concat(userName));
        return null;
    }
}
