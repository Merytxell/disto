package fr.fms.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/** article category class definition
 * @author Gilles
 * */
@Entity
@Data //! génère déjà un constructor sans arg
@NoArgsConstructor // ! techniquement pas besoin de celui-ci
@AllArgsConstructor // ! JPA exige un constructor PUBLIC sans args
@ToString
public class Category  implements Serializable {
    /**
     * category id
     * */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * category name
     * */
    private String name;
    /**
     * category description
     * */
    private String description;

    /**
     * article in a category
     * */
    @OneToMany (mappedBy = "category")
    @ToString.Exclude
    private Collection<Article> articles;

}

