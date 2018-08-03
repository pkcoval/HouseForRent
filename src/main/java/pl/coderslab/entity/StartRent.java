package pl.coderslab.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class StartRent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date startRent;
    @ManyToOne
    private House houseStartRent;

    public StartRent() {
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
}
