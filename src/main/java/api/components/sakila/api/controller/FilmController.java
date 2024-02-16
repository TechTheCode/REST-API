package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Film;
import api.components.sakila.api.repositories.FilmRepository;
import api.components.sakila.api.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/** A Rest Controller for managing films.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@RestController
@RequestMapping("/home/film")
public class FilmController {
    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private FilmService filmService;

    /**
     * Retrieves a list of all films.
     *
     * @return ResponseEntity containing the list of films and HTTP status OK.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Film>> getAllFilms() {
        List<Film> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    /**
     * Retrieves a film by its ID.
     *
     * @param id The ID of the film to be retrieved.
     * @return ResponseEntity containing the film and HTTP status OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable int id) {
        Film film = filmService.getFilmById(id);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    /**
     * Adds a new film to the system.
     *
     * @param film The film to be added.
     * @return ResponseEntity containing the added film and HTTP status CREATED, or HTTP status INTERNAL_SERVER_ERROR if an error occurs.
     */
    @PostMapping("/add")
    public ResponseEntity<?> addFilm(@RequestBody Film film) {
        try {
            Film newFilm = filmService.addFilm(film);
            return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error adding film: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Updates an existing film.
     *
     * @param id   The ID of the film to be updated.
     * @param film The updated film data.
     * @return ResponseEntity containing the updated film and HTTP status OK.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable int id, @RequestBody Film film) {
        Film updatedFilm = filmService.updateFilm(id, film);
        return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
    }

    /**
     * Deletes a film by its ID.
     *
     * @param id The ID of the film to be deleted.
     * @return ResponseEntity with HTTP status NO_CONTENT if deletion is successful.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable int id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Searches for films by their title.
     *
     * @param title The title of the film(s) to search for.
     * @return ResponseEntity containing the list of films that match the title and HTTP status OK.
     */
    @GetMapping("/search/{title}")
    public ResponseEntity<List<Film>> searchFilms(@PathVariable String title) {
        List<Film> films = filmService.searchFilms(title);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

}
