package api.components.sakila.api.service;

import api.components.sakila.api.domain.Actor;
import api.components.sakila.api.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Iterable<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Actor getActorById(int actorId) {
        return actorRepository.findById(actorId)
                .orElseThrow(() -> new ResourceAccessException("Actor not found"));
    }

    public Actor addActor(Actor newActor) {
        return actorRepository.save(newActor);
    }

    public void deleteActor(int id) {
        actorRepository.deleteById(id);
    }
}
