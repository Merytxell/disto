package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;


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

    private double totalPrice;


    public Movie getMovie() {
        return movie;
    }


    @ManyToOne
    private Movie movie;


    @ManyToOne
    private Order order;

    public void setMovie(Movie movie) {
    }
}




