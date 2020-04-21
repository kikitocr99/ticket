package com.pinhost.mm.discountticketrabbitqmservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class DiscountTicketRabbitqmServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscountTicketRabbitqmServiceApplication.class, args);
    }

}
