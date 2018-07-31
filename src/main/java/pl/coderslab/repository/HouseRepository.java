package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.House;
@Repository
public interface HouseRepository extends JpaRepository<House, Long> {

}
