package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Rating;
import pl.coderslab.entity.User;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
}
