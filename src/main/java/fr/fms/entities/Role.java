package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
/** User role class definition
 * @author Frederic
 * */
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Role implements Serializable {
    /**
     * role id
     * */
    @Id
    private String name;
    /**
     * users list
     * */
    @ManyToMany(mappedBy = "roles")
    @ToString.Exclude
    private Collection<User> users;
}
