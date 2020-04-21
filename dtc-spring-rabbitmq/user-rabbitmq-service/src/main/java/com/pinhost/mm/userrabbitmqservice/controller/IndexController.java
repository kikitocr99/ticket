package com.pinhost.mm.userrabbitmqservice.controller;

import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.userrabbitmqservice.component.Receiver;
import com.pinhost.mm.userrabbitmqservice.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Receiver receiver;



    @GetMapping("/{name}")
    public UserModel getUser(@PathVariable("name") final String name) {
        UserModel userModel = userService.getUserByName(name);
        com.pinhost.mm.userrabbitmqservice.jsonconfig.UserModel userJson = new com.pinhost.mm.userrabbitmqservice.jsonconfig.UserModel(userModel.getId(),
        userModel.getName(), userModel.getDescription(), userModel.getRoleId(), userModel.getUserRoles(), userModel.getPassword(),
                userModel.getPasswordChangeDate(), userModel.getPasswordErrorCount(), userModel.isEnabled(),userModel.getDeletedTime(),
                userModel.getDeletedComment(),userModel.getFirstName(), userModel.getFamilyName(), userModel.getUserMailAddress());
        rabbitTemplate.convertAndSend("spring-boot-exchange", "foo.bar.bar", userJson);
        return userModel;
    }
}
