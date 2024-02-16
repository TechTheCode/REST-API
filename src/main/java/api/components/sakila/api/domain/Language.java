package api.components.sakila.api.domain;

import jakarta.persistence.*;
import java.util.Set;

/**
 * Represents a language used in films.
 * Maps to the 'language' table in the database.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@Entity
@Table(name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id", nullable = false)
    private byte languageId;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * A set of films that use this language.
     * Defined as a one-to-many relationship with the 'Film' entity.
     * The 'language' field in the Film class maps to this relationship.
     */
    @OneToMany(mappedBy = "language")
    private Set<Film> films;

    public Language() {
    }

    public byte getLanguageId() {
        return languageId;
    }

    public void setLanguageId(byte languageId) {
        this.languageId = languageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

}
