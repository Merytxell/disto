package fr.fms.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Za-z0-9._-]+@[A-Za-z0-9._-]+\\.[a-z]{2,}$",
            message = "Invalid email")
    private String email;

    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])).{6,}$",
            message = "password must contains at least 1 uppercase, 1 lowercase, 1 special character and 1 digit")
    private String password;

    @ManyToMany
    private Collection<Role> roles;
}
