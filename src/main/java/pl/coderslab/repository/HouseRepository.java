package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.House;
import pl.coderslab.entity.Rating;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

    List<House> findAllByOrderByPriceAsc ();
    List<House> findAllByOrderByPriceDesc ();
    List<House> findAllByOrderByNameDesc ();

    List<House> findAllByPriceLessThan(double price);
    List<House> findAllByPriceGreaterThan(double price);

    List<House> findAllByAverageLessThan(double rating);
    List<House> findAllByAverageGreaterThan(double rating);

    List<House> findByName(String name);
}
