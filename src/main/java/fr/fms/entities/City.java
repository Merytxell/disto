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
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cityName;


    @OneToMany(mappedBy = "city")
    private Collection<Cinema> cinema;

    public City(String cityName) {
        this.cityName=cityName;
    }

    public static boolean isEmpty() {
        return isEmpty();
    }
//    @ToString.Exclude
//    private Collection<Article> articles;
}

