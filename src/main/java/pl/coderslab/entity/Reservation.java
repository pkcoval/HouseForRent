package pl.coderslab.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date startRent;
    private Date endRent;
    private double price;
    private boolean towel;
    private boolean bedclothes;
    @ManyToOne
    private House houseReservation;

    public Reservation() {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public House getHouseReservation() {
        return houseReservation;
    }

    public void setHouseReservation(House houseReservation) {
        this.houseReservation = houseReservation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
