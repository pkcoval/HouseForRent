package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;


    @GetMapping("/add")
    public String addUser(@ModelAttribute User user) {
        return "addUser";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processEdit(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "addUser";
        }
        userRepository.save(user);
        return "user dodany";
    }
}
