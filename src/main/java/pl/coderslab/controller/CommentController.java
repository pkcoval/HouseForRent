package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.House;
import pl.coderslab.entity.Rating;
import pl.coderslab.repository.CommentRepository;
import pl.coderslab.repository.HouseRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    HouseRepository houseRepository;

    @GetMapping("/add")
    public String addUser(@ModelAttribute Comment comment) {
        return "addComment";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processEdit(@Valid Comment comment, BindingResult result) {
        if (result.hasErrors()) {
            return "addComment";
        }
        commentRepository.save(comment);
        return "komentarz dodany";
    }


    @ModelAttribute("allHouse")
    public List<House> getGroups(){
        return houseRepository.findAll();
    }

}
