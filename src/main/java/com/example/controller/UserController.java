package com.example.controller;

import com.example.entity.User;
import com.example.entity.request.AddUserRequest;
import com.example.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by mezz on 26.11.16.
 */


@RestController
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @RequestMapping(method = RequestMethod.GET)
    public List<User> FindAllUsers()
    {
        return userRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addUser(@RequestBody AddUserRequest addUserRequest){

        User user = new User();
        user.setName(addUserRequest.getName());
        user.setSurname(addUserRequest.getSurname());
        userRepository.save(user);


    }




}
