package com.vahan.controller;

import com.vahan.domain.User;
import com.vahan.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.FormParam;


/**
 * Created by TCE\vahany on 3/29/17.
 */
@Controller
@RequestMapping("/posts")
public class UserEndpoints {

    private final UserService userService;

    @Autowired
    public UserEndpoints(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String sayHello() {
        return "Hello user!";
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public User fetchUserById(@PathVariable("id") long id) {

        return userService.getUserById(id);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity loginUser(
            @FormParam("name") String name,
            @FormParam("password") String password) {

        if (!userService.userExists(name, password)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);

    }


    @RequestMapping(value = "/userAdd", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity saveUser(@RequestBody User user) {

        if (userService.nameExists(user.getName().toLowerCase())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userService.saveUser(user.getName().toLowerCase(), user.getPassword());

        return new ResponseEntity<>(HttpStatus.CREATED);

    }


}
