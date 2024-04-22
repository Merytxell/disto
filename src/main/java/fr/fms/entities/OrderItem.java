package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/** Order class definition
 * @author Alejandra
 * */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem implements Serializable {
    /**
     * order id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * order quantity
     * */
    private int quantity ;

    /**
     * order total price
     * */
    private double totalPrice;

    /**
     * order article
     * */
    @ManyToOne
    private Article article;

    }




