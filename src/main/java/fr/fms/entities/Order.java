package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Order class definition
 *
 * @author Frederic
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "t_order")
public class Order implements Serializable {

    /**
     * id auto increment
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Formatted date
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    /**
     * Order total amount
     */
    private double totalAmount;

    /**
     * Entity relationship with customer
     */
    @ManyToOne
    private Customer customer;

    /**
     * Entity relationship with orderItem
     */
    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    private Collection<OrderItem> orderItems;

}
