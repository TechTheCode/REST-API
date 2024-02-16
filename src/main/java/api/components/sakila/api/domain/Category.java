package api.components.sakila.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

/** A film category in the system.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private byte categoryId;

    @Column(length = 50)
    private String name;

    /**
     * A set of films associated with this category.
     * Defined as a many-to-many relationship with the 'Film' entity.
     */
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Set<Film> films;

    public Category() {
    }

    public byte getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(byte categoryId) {
        this.categoryId = categoryId;
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

