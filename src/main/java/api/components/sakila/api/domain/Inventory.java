package api.components.sakila.api.domain;

import jakarta.persistence.*;

/**
 * Represents the inventory of films in the system.
 * Maps to an 'inventory' table in the database.
 * @author Kevin Pham
 * @since JDK 21.0.2
 * @version Feb 2024
 */
@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int inventoryId;

    /**
     * The film associated with this inventory item.
     * Defined as a many-to-one relationship with the 'Film' entity.
     * FetchType.LAZY is used to avoid loading the film data until it's explicitly accessed.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "film_id")
    private Film film;

    public Inventory() {
    }

    public int getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(int inventoryId) {
        this.inventoryId = inventoryId;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }


}