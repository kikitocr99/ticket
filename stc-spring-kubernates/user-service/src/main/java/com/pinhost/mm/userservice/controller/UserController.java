package com.pinhost.mm.userservice.controller;

import com.pinhost.mm.dtcdatabase.model.DiscountTicketCondition;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.userservice.component.DiscountTicketClient;
import com.pinhost.mm.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private DiscountTicketClient discountTicketClient;

    @GetMapping("/{name}")
    public UserModel getUser(@PathVariable("name") final String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/by/id/{username}")
    public Long getUserIdByUserName(@PathVariable("username")final String username){
        return userService.getUserIdByName(username);
    }

    @GetMapping("/by/ticket/{name}")
    public DiscountTicketCondition getDiscountTicket(@PathVariable("name")final String name){
        return discountTicketClient.getOne(name);
    }

    @GetMapping("/all/ticket/by/user/{name}")
    public List<DiscountTicketCondition> getAllDiscountTicket(@PathVariable("name")final String name){
        Long userId = userService.getUserIdByName(name);
        System.out.println("este es el user" + userId);
        return discountTicketClient.getAll(userId);
    }
}

