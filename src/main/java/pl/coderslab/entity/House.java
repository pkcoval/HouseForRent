package pl.coderslab.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.sql.Date;

import java.util.List;

@Entity
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String adress;
    private Date startRent;
    private Date endRent;
    private boolean towel;
    private boolean bedclothes;
    private double price;
    private double average;
    @OneToMany(mappedBy = "houseReservation")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Reservation> reservationList;
    @OneToMany(mappedBy = "house")
    @LazyCollection(LazyCollectionOption.FALSE) // jezeli mamy dwa Egery to sypie bledami ---- dodane ze stack
    private List<Rating> ratingList;
    @OneToMany(mappedBy = "houses")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Comment> commentList;
    @OneToMany( mappedBy = "houseToRent")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> userList;

    public House() {
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public boolean isTowel() {
        return towel;
    }

    public void setTowel(boolean towel) {
        this.towel = towel;
    }

    public boolean isBedclothes() {
        return bedclothes;
    }

    public void setBedclothes(boolean bedclothes) {
        this.bedclothes = bedclothes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Date getStartRent() {
        return startRent;
    }

    public void setStartRent(Date startRent) {
        this.startRent = startRent;
    }

    public Date getEndRent() {
        return endRent;
    }

    public void setEndRent(Date endRent) {
        this.endRent = endRent;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
