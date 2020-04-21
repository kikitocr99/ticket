package com.pinhost.discountticketcondition.service;

import com.pinhost.discountticketcondition.DiscountTicketConditionApplication;
import com.pinhost.discountticketcondition.config.DataSorceTestConfig;
import com.pinhost.discountticketcondition.mocking.UserServiceMock;
import com.pinhost.discountticketcondition.services.UserServiceDTO;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {DiscountTicketConditionApplication.class, DataSorceTestConfig.class})
public class UserServiceTest {

    @Autowired
    private UserServiceDTO userServiceDTO;

    @Autowired
    private UserServiceMock userServiceMock;

    @Test
    public void userByNameTest(){
        UserModel userModel = userServiceDTO.getUserByName("lnaranjo");
        Mockito.when(userServiceMock.getUserModel("lnaranjo")).thenReturn(userModel);
    }
}
