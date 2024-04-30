package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cinema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cinemaName;
    private String address;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "cinema")
    @ToString.Exclude
    private Collection<Movie> movie;

    public Cinema(String cinemaName, String address, City city,Movie movie) {
        this.cinemaName=cinemaName;
        this.address=address;
        this.city=city;
        this.movie= (Collection<Movie>) movie;

    }


    public static boolean isEmpty() {
        return isEmpty();
    }
}

//   @OneToMany(mappedBy = "cinema")
//     @ToString.Exclude
//  private Collection<> articles;

