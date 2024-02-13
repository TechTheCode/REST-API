package api.components.sakila.api;

import api.components.sakila.api.domain.Film;
import api.components.sakila.api.domain.Language;
import api.components.sakila.api.repositories.FilmRepository;
import api.components.sakila.api.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
@CrossOrigin
@SpringBootApplication
public class RestApiApplication {
	//Make constructors here
	/*
	@Autowired
	private ActorRepository actorRepo;

	 */

	@Autowired
	private FilmRepository filmRepository;

	@Autowired
	private LanguageRepository languageRepository;
	/*
	public RestApiApplication(ActorRepository actorRepo) {
		this.actorRepo = actorRepo;
	}
	@GetMapping("/allActors")
	public Iterable<Actor> getAllActors() {
		return actorRepo.findAll();
	}

	@GetMapping("actor/{id}")
	public Actor getActorByID(@PathVariable("id") int actorID) {
		return actorRepo.findById(actorID).
				orElseThrow(() -> new ResourceAccessException("Actor not found"));
	}

	@PostMapping("/addActor")
	public ResponseEntity<?> addActor(@RequestBody Actor newActor) {
		try {
			Actor savedActor = actorRepo.save(newActor);
			return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteActor/{id}")
	public ResponseEntity<?> deleteActor(@PathVariable int id) {
		if (!actorRepo.existsById(id)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Actor not found with id: " + id);
		}
		actorRepo.deleteById(id);
		//RESPONSE SENT
		return ResponseEntity.ok().body("Actor deleted successfully");
	}

	@PutMapping("/updateActor/{id}")
	public ResponseEntity<Actor> updateActor(@PathVariable("id") int actorID, @RequestBody Actor actorDetails) {
		Actor updateActor = actorRepo.findById(actorID)
				.orElseThrow(() -> new RuntimeException("Actor not found for this id :: " + actorID));
		updateActor.setFirstName(actorDetails.getFirstName());
		updateActor.setLastName(actorDetails.getLastName());
		Actor actorSaved = actorRepo.save(updateActor);

		return ResponseEntity.ok(actorSaved);
	}

	 */

	@GetMapping("/allFilms")
	public ResponseEntity<List<Film>> getAllFilms() {
		List<Film> films = filmRepository.findAll();
		return new ResponseEntity<>(films, HttpStatus.OK);
	}

	@GetMapping("/allLanguage")
	public List<Language> getAllLanguages() {
		return languageRepository.findAll();
	}

	@GetMapping("/category/{categoryId}")
	public List<Film> getFilmsByCategory(@PathVariable Long categoryId) {
		return filmRepository.findFilmsByCategoryId(categoryId);
	}

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

}
