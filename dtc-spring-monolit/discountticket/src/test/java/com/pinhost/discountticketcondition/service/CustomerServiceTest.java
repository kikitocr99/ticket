package com.pinhost.discountticketcondition.service;


import com.pinhost.discountticketcondition.DiscountTicketConditionApplication;
import com.pinhost.discountticketcondition.config.DataSorceTestConfig;
import com.pinhost.discountticketcondition.controller.CustomerController;
import com.pinhost.discountticketcondition.services.CustomerService;
import com.pinhost.mm.dtcdatabase.model.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = {DiscountTicketConditionApplication.class,DataSorceTestConfig.class})
public class CustomerServiceTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    public void test(){
        Customer customer = customerService.getCustomer("Luis");

        Assert.assertEquals(customer, customerController.getCustomer("Luis"));
    }
}
