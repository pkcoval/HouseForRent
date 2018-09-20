package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.House;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    List<House> findAllByOrderByPriceAsc ();
    List<House> findAllByOrderByPriceDesc ();
//    List<House> findAllByOrOrderByName ();
}
