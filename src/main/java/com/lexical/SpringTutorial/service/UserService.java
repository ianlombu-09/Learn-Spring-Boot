package com.lexical.SpringTutorial.service;

import com.lexical.SpringTutorial.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserDto createUser(UserDto user);
    UserDto getUser(String email);
    UserDto getUserById(String userId);
    UserDto updateUser(String userId, UserDto user);
    void deleteUser(String userId);
    List<UserDto> getUsers(int page, int limit);
}
