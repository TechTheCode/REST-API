package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import api.components.sakila.api.repositories.FilmRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/** A Rest Controller for managing film categories.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@RestController
@RequestMapping("/home/category")
public class CategoryController {
    @Autowired
    private FilmRepository filmRepository;
    /**
     * Retrieves a list of films belonging to a specific category.
     *
     * @param categoryId The ID of the category for which films are to be retrieved.
     * @return A List of {@link Film} objects belonging to the specified category.
     */
    @GetMapping("/{categoryId}")
    public List<Film> getFilmsByCategory(@PathVariable Long categoryId) {
        return filmRepository.findFilmsByCategoryId(categoryId);
    }
}
