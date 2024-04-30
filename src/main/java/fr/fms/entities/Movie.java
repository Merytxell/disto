package fr.fms.entities;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Movie implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String movieName;
    private double price;
    private String date;



    @ManyToOne
    private Cinema cinema;

    public Movie(String movieName, double price, Cinema cinema, String  date) {
        this.movieName = movieName;
        this.price = price;
        this.cinema = cinema;
        this.date=date;

    }





//    @OneToMany(mappedBy = "article")
//    @ToString.Exclude
//    private Collection<OrderItem> orderItems;



}
