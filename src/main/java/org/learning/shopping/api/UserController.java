package org.learning.shopping.api;

import org.learning.shopping.entity.User;
import org.learning.shopping.service.UserService;
import org.learning.shopping.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/profile/{email}")
    public User findByEmail(@PathVariable("email")String email){

        System.out.println(userService.findOne(email));

        return  userService.findOne(email);
    }
}
