package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * OrderItem class definition
 *
 * @author Frederic
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    /**
     * total price of each order items
     */
    private double totalPrice;

    /**
     * Entity relationship with article
     */
    @ManyToOne
    private Movie movie;

    /**
     * Entity relationship with order
     */
    @ManyToOne
    private Order order;

    public void setMovie(Movie movie) {
    }
}




