package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must contains characters")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "lastName must contains characters")
    private String lastName;

    @Size(min = 10, max = 50)
    private String address;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10,14}$", message = "contains only numbers")
    private String phone;

    @OneToMany(mappedBy = "customer")
    private Collection<Order> orders;

}
