package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.*;
import pl.coderslab.repository.HouseRepository;
import pl.coderslab.repository.ReservationRepository;
import pl.coderslab.repository.UserRepository;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseRepository houseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ReservationRepository reservationRepository;

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
//        Reservation reservation = new Reservation();
//        model.addAttribute("reservation", reservation);
        model.addAttribute("houseToRent", houseToRent);
        return "rent";
    }

    @RequestMapping(value = "/rent/{id}", method = RequestMethod.POST)
    public String processEdit(@ModelAttribute House houseToRent, @PathVariable long id, Model model) {



        double resultRating = 0.0;
        List<Rating> ratings = houseRepository.findOne(id).getRatingList();
        for (Rating r : ratings) {
            resultRating += r.getRating();
        }
        resultRating = resultRating / ratings.size();


        model.addAttribute("resultRating", String.format("%.2f", resultRating)); // nic nie wyswietla tak jak by nie dodal tego atrybutu

        houseRepository.findOne(id).setAverage(resultRating);//ustawiamy wynajetemu domkowi  srednia nie dziala


        houseRepository.save(houseToRent);
        User user = houseToRent.getUserList().get(0);
        user.setHouseToRent(houseToRent);

        Reservation reservation1 = new Reservation();
        reservation1.setHouseReservation(houseToRent);

        List<Reservation> listR = reservationRepository.findByHouseReservation_Id(id);

        int newStart = houseToRent.getStartRent().toLocalDate().getDayOfMonth();
        int newEnd = houseToRent.getEndRent().toLocalDate().getDayOfMonth();

        double price = houseToRent.getPrice();
        if (houseToRent.isBedclothes() == true) {
            price = price + 20.0;
            reservation1.setBedclothes(true);
        }
        if (houseToRent.isTowel() == true) {
            price = price + 10.0;
            reservation1.setTowel(true);
        }
        int rentingDay = newEnd - newStart;
        double endPrice = price * rentingDay;

        boolean reservationStatus = false;
        for (Reservation r : listR) {
            int reservationStart = r.getStartRent().toLocalDate().getDayOfMonth();
            int reservationEnd = r.getEndRent().toLocalDate().getDayOfMonth();



            if (newStart > newEnd) {
                return "redirect:/house/dataFalse";
            }

            if (r.getStartRent().toLocalDate().getYear() == houseToRent.getStartRent().toLocalDate().getYear() &&
                    r.getStartRent().toLocalDate().getMonth() == houseToRent.getStartRent().toLocalDate().getMonth()) {
                if (  (newStart > reservationStart && newStart < reservationEnd) ||
                        newEnd > reservationStart && newEnd < reservationEnd ||
                        newStart < reservationStart && newEnd > reservationEnd ||
                        newStart == reservationStart && newEnd >= reservationEnd ||
                        newStart <= reservationStart && newEnd == reservationEnd) {
                    reservationStatus = true;
                }
            }
        }

        if (reservationStatus == true) {
            return "redirect:/house/reservation/"+id;
        } else {
            reservation1.setStartRent(houseToRent.getStartRent());
            reservation1.setEndRent(houseToRent.getEndRent());
            reservation1.setPrice(endPrice);
            List<Reservation> reservationList = user.getReservationList();
            reservationList.add(reservation1);
            reservationRepository.save(reservation1);
        }
        userRepository.save(user);

        return "operationCompleted";
    }

    @RequestMapping(value = "/dataFalse", method = RequestMethod.GET)
    public String reservation() {

        return "dataFalse";
    }

    @RequestMapping(value = "/reservation/{id}", method = RequestMethod.GET)
    public String reservation(@PathVariable long id, Model model) {


        List<Reservation> reservationList = houseRepository.findOne(id).getReservationList();
        model.addAttribute("reservationList", reservationList);
        return "reservation";
    }

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
