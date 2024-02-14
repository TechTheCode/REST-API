package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Film;
import api.components.sakila.api.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home/films")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmRepository.findAll();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
}
