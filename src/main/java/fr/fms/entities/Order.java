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


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;


    private double totalAmount;


    @ManyToOne
    private Customer customer;


    @OneToMany(mappedBy = "order")
    @ToString.Exclude
    private Collection<OrderItem> orderItems;

}
