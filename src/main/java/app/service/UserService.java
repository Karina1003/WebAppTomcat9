package app.service;

import app.dto.UserDto;

import java.util.Map;

public interface UserService {
    UserDto getUser(String username);

    void addUser(String username, String pass, String name);

    Map getMap();

    boolean checkUser(UserDto user);
}
