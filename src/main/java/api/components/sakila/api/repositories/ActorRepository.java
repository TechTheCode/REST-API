package api.components.sakila.api.repositories;

import api.components.sakila.api.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Integer> {
    @Query("SELECT a FROM Actor a WHERE a.firstName LIKE %:name% OR a.lastName LIKE %:name%")
    List<Actor> searchByFirstNameOrLastName(String name);
}
