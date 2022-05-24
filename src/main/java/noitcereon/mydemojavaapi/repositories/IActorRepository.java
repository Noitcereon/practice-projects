package noitcereon.mydemojavaapi.repositories;

import noitcereon.mydemojavaapi.models.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface IActorRepository extends JpaRepository<Actor, String> {
    Set<Actor> findAllByIsDeletedIsFalse();
    Actor findByUuidAndIsDeletedIsFalse(String uuid);
}