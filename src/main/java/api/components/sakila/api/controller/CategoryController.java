package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import api.components.sakila.api.repositories.FilmRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home/category")
public class CategoryController {
    @Autowired
    private FilmRepository filmRepository;
    @GetMapping("/{categoryId}")
    public List<Film> getFilmsByCategory(@PathVariable Long categoryId) {
        return filmRepository.findFilmsByCategoryId(categoryId);
    }
}
