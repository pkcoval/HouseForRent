package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.entity.House;
import pl.coderslab.entity.Rating;
import pl.coderslab.repository.HouseRepository;
import pl.coderslab.repository.RatingRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/rating")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    HouseRepository houseRepository;


    @GetMapping("/add")
    public String addUser(@ModelAttribute Rating rating) {
        return "addRating";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String processEdit(@Valid Rating rating, BindingResult result) {
        if (result.hasErrors()) {
            return "addRating";
        }
        rating.getHouse().setAverage((rating.getHouse().getAverage() + rating.getRating()) / 2);
        ratingRepository.save(rating);
        return "operationCompleted";
    }

    @ModelAttribute("allHouse")
    public List<House> getGroups() {

        return houseRepository.findAll();
    }


}
