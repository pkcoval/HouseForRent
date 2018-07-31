package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.House;
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

    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, Model model) {

        double resultRating = 0.0;
        List<Rating> ratings = houseRepository.findOne(id).getRatingList();
        for (Rating r : ratings) {
            resultRating += r.getRating();
        }
        resultRating = resultRating/ratings.size();
        model.addAttribute("resultRating", String.format( "%.2f", resultRating ));
        model.addAttribute("ratingsSize", ratings.size());
        List<Comment> comments = houseRepository.findOne(id).getCommentList();
        model.addAttribute("comments", comments);



        return "details"  ;
    }



    @GetMapping("/all")
    public String allHouses(Model model) {

        List<House> houseList = houseRepository.findAll();
        model.addAttribute("houseList", houseList);
        return "allHouses"  ;
    }






}
