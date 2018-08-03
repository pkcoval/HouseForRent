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
    @ManyToOne
    private House houseReservation;

    public Reservation() {
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
}
