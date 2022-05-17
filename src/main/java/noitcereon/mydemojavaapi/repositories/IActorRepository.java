package noitcereon.mydemojavaapi.repositories;

import noitcereon.mydemojavaapi.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, String> {
}