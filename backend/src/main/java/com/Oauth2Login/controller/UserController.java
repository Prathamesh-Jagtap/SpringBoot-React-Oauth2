package com.Oauth2Login.controller;
import com.Oauth2Login.entity.User;
import com.Oauth2Login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/profile")
    public Optional<User> profile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated.");
        }

        Object principal = authentication.getPrincipal();
        String email = null;

        // Check if the principal is an OidcUser (OpenID Connect user)
        if (principal instanceof OidcUser) {
            OidcUser oidcUser = (OidcUser) principal;
            email = oidcUser.getEmail();  // OIDC provides a direct getEmail() method

            // Otherwise, check if the principal is a generic OAuth2User
        } else if (principal instanceof OAuth2User) {
            OAuth2User oauth2User = (OAuth2User) principal;
            Map<String, Object> attributes = oauth2User.getAttributes();
            email = (String) attributes.get("email");  // Extract email from attributes
        }

        if (email == null) {
            throw new RuntimeException("Could not extract email from OAuth2 user.");
        }

        System.out.println("Authenticated User: " + email);

        // Fetch user from the database using the email
        return Optional.ofNullable(userRepository.findByEmail(email));
    }
}

