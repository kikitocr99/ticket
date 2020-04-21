package com.pinhost.mm.customerkafkaservice.service;

import com.pinhost.mm.dtcdatabase.model.Customer;
import com.pinhost.mm.dtcdatabase.repositories.CustomerRepositoryH2;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private static final Log LOG = LogFactory.getLog(CustomerService.class);

    private CustomerRepositoryH2 customerRepositoryH2;

    public CustomerService(){
        this.customerRepositoryH2 = new CustomerRepositoryH2();
    }

    public com.pinhost.mm.dtcdatabase.model.Customer getCustomer(String name) {
        com.pinhost.mm.dtcdatabase.model.Customer customer = customerRepositoryH2.getCustomerByName(name);
        if (customer != null) {
            LOG.info("Custommer " + customer.toString() + "wurde gefunden.");
            return customer;
        }
        LOG.error("Der Customer wurde nicht gefunden.");
        return null;
    }

    public com.pinhost.mm.dtcdatabase.model.Customer getCustomerById(Integer id) {
        com.pinhost.mm.dtcdatabase.model.Customer customer = customerRepositoryH2.getCustomerById(id);
        if (customer != null) {
            LOG.info("Custommer " + customer.toString() + "wurde gefunden.");
            return customer;
        }
        LOG.error("Der Customer mit dem Id " + id + " wurde nicht gefunden.");
        return null;
    }

    public Customer getCustomerByUserId(final Long userId ) {
        if (userId != null) {
            return customerRepositoryH2.getCustomerByUserId(userId);
        }
        LOG.error("Es wurde keinen Customer mit diesem id gefunden.");
        return null;
    }
}
