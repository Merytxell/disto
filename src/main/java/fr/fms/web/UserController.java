package fr.fms.web;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    /**
     * Method to get the current username of logged user
     *
     * @param authentication context
     * @return username
     */

    @GetMapping("/username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}
