package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.House;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

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
        return "operationCompleted";
    }

    @ResponseBody
    @GetMapping("/rent/{id}")
    public String rentHous(@PathVariable long id) {
        User user = userRepository.findOne(id);
        return user.getHouseToRent().getName();

    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String allUser(Model model) {
        List<User> userList = userRepository.findAll();
        model.addAttribute("userList", userList);
        return "allUser";
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String userReservation(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("user", user);
        return "reservationHouse";
    }


}
