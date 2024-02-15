package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Film;
import api.components.sakila.api.repositories.FilmRepository;
import api.components.sakila.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/film")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmService filmService;
    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable int id) {
        Film film = filmService.getFilmById(id);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> addFilm(@RequestBody Film film) {
        try {
            Film newFilm = filmService.addFilm(film);
            return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding film: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable int id, @RequestBody Film film) {
        Film updatedFilm = filmService.updateFilm(id, film);
        return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable int id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search/{title}")
    public ResponseEntity<List<Film>> searchFilms(@PathVariable String title) {
        List<Film> films = filmService.searchFilms(title);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

}
