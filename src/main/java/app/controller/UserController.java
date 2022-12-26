package app.controller;

import app.dto.UserDto;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping()
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView logIn() {
        UserDto user = new UserDto();
        ModelAndView model = new ModelAndView("login/login");
        model.addObject("user", user);
        return model;
    }

    @PostMapping("/login")
    public ModelAndView logOut() {
        UserDto user = new UserDto();
        ModelAndView model = new ModelAndView("login/login");
        model.addObject("user", user);
        return model;
    }

    @PostMapping("/user")
    public ModelAndView getUser(UserDto userReceived) {
        UserDto user = userService.getUser(userReceived.getUsername());
        ModelAndView model = new ModelAndView("user/user");
        if (user != null) {
            user.setLoggedIn(true);
        }
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

    @PostMapping("/userList")
    public ModelAndView getUserList(UserDto userReceived) {
        ModelAndView model = new ModelAndView("user/userList");
        model.addObject("userList", userService.getMap());
        return model;
    }
}
