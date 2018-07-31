package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.Rating;
import pl.coderslab.repository.HouseRepository;

import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @ResponseBody
    @GetMapping("/rating/{id}")
    public String averageRating(@PathVariable long id, Model model) {

        double resultRating = 0.0;
        List<Rating> ratings = houseRepository.findOne(id).getRatingList();
        for (Rating r : ratings) {
           resultRating += r.getRating();
        }

        resultRating = resultRating/ratings.size();

        return "Ocena: " + String.format( "%.2f", resultRating )  ;
    }


    @GetMapping("/comment/{id}")
    public String allComments(@PathVariable long id, Model model) {

        List<Comment> comments = houseRepository.findOne(id).getCommentList();
        model.addAttribute("comments", comments);
        return "allComments"  ;
    }






}
