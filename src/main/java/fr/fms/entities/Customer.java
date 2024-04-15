package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must contains alphabetic characters")
    private String name;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "name must contains alphabetic characters")
    private String lastName;

    @Size(min = 10, max = 50)
    private String address;

    @Pattern(regexp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]{2,}$",
            message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^[0-9]{10,14}$", message = "only contains numbers")
    private String phone;



}
