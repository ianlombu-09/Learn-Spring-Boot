package com.lexical.SpringTutorial.ui.controller;

import com.lexical.SpringTutorial.service.UserService;
import com.lexical.SpringTutorial.shared.dto.UserDto;
import com.lexical.SpringTutorial.ui.model.request.UserDetailsRequestModel;
import com.lexical.SpringTutorial.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(path="/{id}")
    public UserRest getUser(@PathVariable String id) {
        UserRest returnValue = new UserRest();

        UserDto userDto = userService.getUserById(id);
        BeanUtils.copyProperties(userDto, returnValue);

        return returnValue;
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue; 
    }

    @PutMapping
    public String updateUser() {
        return "Update user";
    }

    @DeleteMapping
    public String deleteUser() {
        return "Delete User";
    }
}
