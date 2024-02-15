package api.components.sakila.api.service;

import api.components.sakila.api.domain.Film;
import api.components.sakila.api.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    public Film getFilmById(int filmId) {
        return filmRepository.findById(filmId)
                .orElseThrow(() -> new ResourceAccessException("Film not found"));
    }

    public Film addFilm(Film newFilm) {
        return filmRepository.save(newFilm);
    }

    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }

    public Film updateFilm(int id, Film filmDetails) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Film not found with id: " + id));

        film.setTitle(filmDetails.getTitle());
        film.setDescription(filmDetails.getDescription());
        film.setReleaseYear(filmDetails.getReleaseYear());

        return filmRepository.save(film);
    }

    public List<Film> searchFilms(String title) {
        return filmRepository.searchByTitle(title);
    }
}
