package com.pinhost.mm.customerrabbitmqservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class CustomerRabbitmqServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRabbitmqServiceApplication.class, args);
    }

}
