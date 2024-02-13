package api.components.sakila.api.controller;

import api.components.sakila.api.domain.Actor;
import api.components.sakila.api.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

@RestController
@RequestMapping("/home/actor")
public class ActorController {

    @Autowired
    private ActorService actorService;

    @GetMapping("/all")
    public ResponseEntity<Iterable<Actor>> getAllActors() {
        return new ResponseEntity<>(actorService.getAllActors(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable("id") int actorId) {
        try {
            Actor actor = actorService.getActorById(actorId);
            return new ResponseEntity<>(actor, HttpStatus.OK);
        } catch (ResourceAccessException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Actor> addActor(@RequestBody Actor newActor) {
        try {
            Actor savedActor = actorService.addActor(newActor);
            return new ResponseEntity<>(savedActor, HttpStatus.CREATED);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteActor(@PathVariable int id) {
        try {
            actorService.deleteActor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}