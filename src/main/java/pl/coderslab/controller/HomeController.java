package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Rating;
import pl.coderslab.repository.RatingRepository;

@Controller
public class HomeController {



    @GetMapping("/")

    public String indexAction() {
        return "index";
    }



}