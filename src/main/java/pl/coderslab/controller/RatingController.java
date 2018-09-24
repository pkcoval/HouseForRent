package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.House;
import pl.coderslab.entity.Rating;
import pl.coderslab.repository.HouseRepository;
import pl.coderslab.repository.RatingRepository;

import javax.persistence.Id;
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
        House houseForRating = rating.getHouse();
        houseForRating.setAverage((houseForRating.getAverage() + rating.getRating()) / 2);


//        System.out.println("nnn"+house.getName());//nie pobiera danych o domku name =null

        System.out.println("zzz" + rating.getHouse().getAverage()); //pokazuje average = polowa wpisanej wartosci??
//        houseRepository.save(houseForRating);
        ratingRepository.save(rating);


        return "operationCompleted";
    }

    @ModelAttribute("allHouse")
    public List<House> getGroups() {

        return houseRepository.findAll();
    }


}
