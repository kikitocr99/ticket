package com.pinhost.discountticketcondition.config;

import com.pinhost.discountticketcondition.mocking.UserServiceMock;
import com.pinhost.discountticketcondition.services.UserServiceDTO;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class UserServiceTestConfig {


    @Bean
    @Primary
    public UserServiceMock userServiceDTOTest(){
        return Mockito.mock(UserServiceMock.class);
    }
}
