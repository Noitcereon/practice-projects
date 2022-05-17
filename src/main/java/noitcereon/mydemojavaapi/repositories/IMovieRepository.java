package noitcereon.mydemojavaapi.repositories;

import noitcereon.mydemojavaapi.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovieRepository extends JpaRepository<Movie, String> {
}