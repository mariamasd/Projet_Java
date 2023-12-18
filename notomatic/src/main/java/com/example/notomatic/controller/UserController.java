package com.example.notomatic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.notomatic.models.User;
import com.example.notomatic.repositories.UserRepository;

import java.util.List;
import java.util.Map;

import javax.naming.AuthenticationException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return true;
    }
    @PostMapping("/inscription")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        // Ajoutez la logique d'inscription ici
        try {
            // Assurez-vous de valider les informations, de hacher le mot de passe, etc.
            userRepository.save(user);
            return ResponseEntity.ok("Utilisateur enregistré avec succès");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("L'inscription a échoué : " + e.getMessage());
        }
    }
    @PostMapping("/connexion")
    public ResponseEntity<String> loginUser(@RequestBody Map<String, String> credentials) {
        // Ajoutez la logique de connexion ici
        try {
            String email = credentials.get("email");
            String password = credentials.get("password");
    
            // Implémentez la logique d'authentification, vérification du mot de passe, etc.
            // Vous pouvez utiliser Spring Security pour une sécurité robuste.
    
            // Exemple de vérification basique (à adapter à votre logique réelle)
            if ("user@example.com".equals(email) && "password123".equals(password)) {
                return ResponseEntity.ok("Connexion réussie");
            } else {
                throw new AuthenticationException("Identifiants invalides");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("La connexion a échoué : " + e.getMessage());
        }
    }
    
    @DeleteMapping("/deconnexion")
    public ResponseEntity<String> logoutUser() {
        // Ajoutez la logique de déconnexion ici
        try {
            // Implémentez la logique de déconnexion, invalidation de la session, etc.
    
            return ResponseEntity.ok("Déconnexion réussie");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("La déconnexion a échoué : " + e.getMessage());
        }
    }
    
    @PutMapping("/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
    User user = userRepository.findById(id).orElse(null);

    if (user != null) {
        // Mettez à jour les détails de l'utilisateur ici en utilisant les informations de userDetails
        user.setPseudoname(userDetails.getPseudoname());
        user.setEmail(userDetails.getEmail());
        // Autres mises à jour nécessaires

        return userRepository.save(user);
    } else {
        // Gérer le cas où l'utilisateur n'est pas trouvé
        return null;
    }
}

    
    
}


