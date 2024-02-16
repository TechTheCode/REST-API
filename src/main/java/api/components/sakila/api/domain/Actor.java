package api.components.sakila.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

/** A entity class for Actor.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@Entity
@Table(name="actor")
public class Actor {

    @Id
    @Column(name="actor_id",unique=true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short actorID;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    /**
     * Set of films associated with the actor.
     * This field is ignored in JSON serialization.
     */
    @ManyToMany(mappedBy = "actors")
    @JsonIgnore
    private Set<Film> films = new HashSet<>();

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public short getActorID() {
        return actorID;
    }

    public void setActorID(short actorID) {
        this.actorID = actorID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
