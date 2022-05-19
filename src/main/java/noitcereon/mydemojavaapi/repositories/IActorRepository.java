package noitcereon.mydemojavaapi.repositories;

import noitcereon.mydemojavaapi.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IActorRepository extends JpaRepository<Actor, String> {
    // TODO: Add getAll that filters deleted actors away
    // TODO: Add FindById that does not select deleted actors
}