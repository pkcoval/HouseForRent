package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Comment;
import pl.coderslab.entity.House;
import pl.coderslab.entity.Rating;
import pl.coderslab.entity.User;
import pl.coderslab.repository.HouseRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    UserRepository userRepository;

//    @ResponseBody
//    @GetMapping("/rating/{id}")
//    public String averageRating(@PathVariable long id, Model model) {
//
//        double resultRating = 0.0;
//        List<Rating> ratings = houseRepository.findOne(id).getRatingList();
//        for (Rating r : ratings) {
//            resultRating += r.getRating();
//        }
//
//        resultRating = resultRating / ratings.size();
//
//        return "Ocena: " + String.format("%.2f", resultRating);
//    }


    @GetMapping("/comment/{id}")
    public String allComments(@PathVariable long id, Model model) {

        List<Comment> comments = houseRepository.findOne(id).getCommentList();
        model.addAttribute("comments", comments);
        return "allComments";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable long id, Model model) {

        double resultRating = 0.0;
        List<Rating> ratings = houseRepository.findOne(id).getRatingList();
        for (Rating r : ratings) {
            resultRating += r.getRating();
        }
        resultRating = resultRating / ratings.size();
        model.addAttribute("resultRating", String.format("%.2f", resultRating));
        model.addAttribute("ratingsSize", ratings.size());
        List<Comment> comments = houseRepository.findOne(id).getCommentList();
        model.addAttribute("comments", comments);
        return "details";
    }


    @RequestMapping(value = "/rent/{id}", method = RequestMethod.GET)
    public String rent(@PathVariable long id, Model model) {
        House houseToRent = houseRepository.findOne(id);
        model.addAttribute("houseToRent", houseToRent);
        return "rent";
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.POST)
    public String processEdit(@ModelAttribute House houseToRent, BindingResult result,  @PathVariable long id) {
        houseRepository.save(houseToRent);
        System.out.println(houseToRent.getUserList().get(0).getFirstName());
        houseToRent.getUserList().get(0).setHouseToRent(houseToRent);
        return "domek wynajety";
    }

//    @RequestMapping(value = "/rent/{id}", method = RequestMethod.POST)
//    public String processEdit(@RequestParam String name, @PathVariable long id) {
//        System.out.println(name);
////        houseRepository.save(houseToRent);
//        return "domek wynajety";
//    }


    @ResponseBody
    @RequestMapping(value = "/userList/{id}", method = RequestMethod.GET)
    public String showUserList(@PathVariable long id) {
        House houseToShow = houseRepository.findOne(id);
        return "Lista Użutkowników" + houseToShow.getUserList().get(0).getFirstName();
    }


    @GetMapping("/all")
    public String allHouses(Model model) {
        List<House> houseList = houseRepository.findAll();
        model.addAttribute("houseList", houseList);
        return "allHouses";
    }

    @GetMapping("/allPriceAsc")
    public String allHousesByPrice(Model model) {
        List<House> houseList = houseRepository.findAllByOrderByPriceAsc();
        model.addAttribute("houseList", houseList);
        return "allHouses";
    }


    @ModelAttribute("allUsers")
    public List<User> getGroups() {
        return userRepository.findAll();
    }


}
