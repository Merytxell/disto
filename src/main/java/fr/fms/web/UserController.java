package fr.fms.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {


    @GetMapping("/username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}
