package com.pinhost.discountticketcondition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = {"http://localhost:4200"})
@SpringBootApplication
@EnableScheduling
public class DiscountTicketConditionApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscountTicketConditionApplication.class, args);
    }

}
