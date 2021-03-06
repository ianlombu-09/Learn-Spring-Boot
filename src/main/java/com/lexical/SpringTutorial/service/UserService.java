package com.lexical.SpringTutorial.service;

import com.lexical.SpringTutorial.shared.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto user);
}
