package com.pinhost.mm.userkafkaservice.controller;

import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.userkafkaservice.consumer.DiscountTicketConsumer;
import com.pinhost.mm.userkafkaservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private KafkaTemplate<String, UserModel> kafkaTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private DiscountTicketConsumer discountTicketConsumer;

    @GetMapping("/{name}")
    public com.pinhost.mm.dtcdatabase.model.UserModel getCustomer(@PathVariable("name") final String name) {
        com.pinhost.mm.dtcdatabase.model.UserModel user = userService.getUserByName(name);
        kafkaTemplate.send("mm.user", user.getId() + "created", user);
        return user;
    }


}
