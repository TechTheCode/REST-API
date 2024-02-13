package api.components.sakila.api.repositories;

import api.components.sakila.api.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActorRepository extends JpaRepository<Actor,Integer> {

}
