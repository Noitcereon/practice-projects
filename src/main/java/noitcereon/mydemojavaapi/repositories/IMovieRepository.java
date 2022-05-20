package noitcereon.mydemojavaapi.repositories;

import noitcereon.mydemojavaapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IMovieRepository extends JpaRepository<Movie, String> {
    Set<Movie> findAllByIsDeletedIsFalse();

    Movie findByUuidAndIsDeletedIsFalse(String uuid);
}
