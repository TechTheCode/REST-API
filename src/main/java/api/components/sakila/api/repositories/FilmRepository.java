package api.components.sakila.api.repositories;

import api.components.sakila.api.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film,Integer> {
    @Query("SELECT f FROM Film f JOIN f.categories c WHERE c.categoryId = :categoryId")
    List<Film> findFilmsByCategoryId(Long categoryId);
}
