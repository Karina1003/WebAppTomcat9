package app.controller;

import app.dto.UserDto;
import app.exception.LoginException;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@Scope("session")
@RequestMapping()
public class UserController {
    @Autowired
    UserService userService;

    //@Autowired
    UserDto user;

    @GetMapping("/login")
    public ModelAndView logIn() {
        if (user != null) {
            user.setLoggedIn(false);
        }
        UserDto user = new UserDto();
        ModelAndView model = new ModelAndView("login/login");
        model.addObject("user", user);
        return model;
    }

    @PostMapping("/user")
    public ModelAndView postUser(UserDto userReceived) {
        user = userService.getUser(userReceived.getUsername());
        ModelAndView model = new ModelAndView("user/user");
        if (user != null && user.getPassword().equals(userReceived.getPassword())) {
            user.setLoggedIn(true);
        } else if (user != null) {
            user.setLoggedIn(false);
        }
        model.addObject("user", user);
        return model;
    }

    @GetMapping("/user")
    public ModelAndView getUserByLink() {
        ModelAndView model = new ModelAndView("user/user");
        model.addObject("user", user);
        return model;
    }

    @GetMapping("/errorLogin")
    public ModelAndView errorLogIn() {
        ModelAndView model = new ModelAndView("login/errorLogin");
        UserDto user = new UserDto();
        model.addObject("user", user);
        return model;
    }


    @GetMapping("/userList")
    public ModelAndView getUserListByLink() {
        if(user == null || !user.isLoggedIn()) {
            throw new LoginException("Not authorized");
        }
        ModelAndView model = new ModelAndView("user/userList");
        model.addObject("userList", userService.getMap());
        model.addObject("user", user);
        return model;
    }
}
