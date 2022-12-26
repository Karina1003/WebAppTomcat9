package app.service;

import app.dto.UserDto;

import java.util.Map;

public interface UserService {
    UserDto getUser(String username);

    Map getMap();
}
