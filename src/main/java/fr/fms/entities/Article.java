package fr.fms.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

/** Article class definition
 * @author Gilles
 * */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Article implements Serializable {
    /**
     * article id
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * article description
     * */
    @NotNull
    @Size(min = 5, max = 50)
    private String description;
    /**
     * article price
     * */
    @DecimalMin("50")
    private double price;
    /**
     * article category
     * */
    @ManyToOne
   private Category category;
    /**
     * cart items
     * */
    @OneToMany(mappedBy = "article")
    @ToString.Exclude
    private Collection<OrderItem> orderItems;



    public Article(String description, double price) {
        this.description = description;
        this.price = price;
    }


}