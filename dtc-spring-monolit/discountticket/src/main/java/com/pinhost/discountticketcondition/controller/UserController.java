package com.pinhost.discountticketcondition.controller;

import com.pinhost.discountticketcondition.services.UserServiceDTO;
import com.pinhost.mm.dtcdatabase.model.UserModel;
import com.pinhost.mm.dtcdatabase.repositories.RoleRepositoryH2;
import com.pinhost.mm.dtcdatabase.repositories.UserRepositoryH2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceDTO userServiceDTO;

    private UserRepositoryH2 userRepositoryH2;

    private RoleRepositoryH2 roleRepositoryH2;

    public UserController() {

        this.userRepositoryH2 = new UserRepositoryH2();
        this.roleRepositoryH2 = new RoleRepositoryH2();
    }
    /*
    @Autowired
    @Qualifier("user_service_entity")
    private UserService userService;

    @GetMapping("/{name}")
    public User getUser(@PathVariable("name") final String name){
        return userService.getUserByName(name);
    }

    @PostMapping("/add")
    public void addUser(@RequestBody final User user){
        userService.addUser(user);
    }
    */
    @GetMapping("/{name}")
    public UserModel getUser(@PathVariable("name") final String name) {
        return userRepositoryH2.getUserByName(name);
    }

    @GetMapping("/users")
    public List<UserModel> getAllUsers(){
        return userRepositoryH2.getAllUsers();
    }
}
