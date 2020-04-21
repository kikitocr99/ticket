package com.pinhost.mm.customerservice.service;

import com.pinhost.mm.customerservice.model.Customer;
import com.pinhost.mm.customerservice.repository.CustomerRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private static final Log LOG = LogFactory.getLog(CustomerService.class);

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(String name) {
        Customer customer = customerRepository.getCustomerByName(name);
        if (customer != null) {
            LOG.info("Custommer " + customer.toString() + "wurde gefunden.");
            return customer;
        }
        LOG.error("Der Customer wurde nicht gefunden.");
        return null;
    }

    public Customer getCustomerById(Integer id) {
        Customer customer = customerRepository.getCustomerById(id);
        if (customer != null) {
            LOG.info("Custommer " + customer.toString() + "wurde gefunden.");
            return customer;
        }
        LOG.error("Der Customer mit dem Id " + id + " wurde nicht gefunden.");
        return null;
    }

    public Customer getCustomerByUserId(final Long userId ) {
        if (userId != null) {
            return customerRepository.getCustomerByUserId(userId);
        }
        LOG.error("Es wurde keinen Customer mit diesem id gefunden.");
        return null;
    }
}
