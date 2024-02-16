package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Actor;
import api.components.sakila.api.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

/** A Rest Controller for managing actors.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@RestController
@RequestMapping("/home/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    /**
     * Retrieves a list of all actors.
     *
     * @return ResponseEntity containing the list of actors and HTTP status OK.
     */
    @GetMapping("/all")
    public ResponseEntity<Iterable<Actor>> getAllActors() {
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    /**
     * Retrieves an actor by their ID.
     *
     * @param actorId The ID of the actor to be retrieved.
     * @return ResponseEntity containing the actor and HTTP status OK, or HTTP status NOT_FOUND if not found.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") int actorId) {
        try {
            Actor actor = actorService.getActorById(actorId);
            return new ResponseEntity<>(actor, HttpStatus.OK);
        } catch (ResourceAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Adds a new actor to the system.
     *
     * @param newActor The actor to be added.
     * @return ResponseEntity containing the added actor and HTTP status CREATED, or HTTP status INTERNAL_SERVER_ERROR if an error occurs.
     */
    @PostMapping("/add")
    public ResponseEntity<Actor> addActor(@RequestBody Actor newActor) {
        try {
            Actor savedActor = actorService.addActor(newActor);
            return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Deletes an actor by their ID.
     *
     * @param id The ID of the actor to be deleted.
     * @return ResponseEntity with HTTP status OK if deletion is successful, or HTTP status INTERNAL_SERVER_ERROR if an error occurs.
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable int id) {
        try {
            actorService.deleteActor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Searches for actors by their name.
     *
     * @param name The name of the actor(s) to search for.
     * @return ResponseEntity containing the list of found actors and HTTP status OK.
     */
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Actor>> searchActors(@PathVariable String name) {
        List<Actor> actors = actorService.searchActors(name);
        return new ResponseEntity<>(actors, HttpStatus.OK);
    }
}