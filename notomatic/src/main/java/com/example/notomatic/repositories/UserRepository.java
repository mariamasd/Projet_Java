package com.example.notomatic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notomatic.models.Note;
import com.example.notomatic.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        // ... autres méthodes
   public interface NoteRepository extends JpaRepository<Note, Long> {

    // Trouver une note par titre
    List<Note> findByTitle(String title);

    // Trouver une note par contenu
    List<Note> findBycontenu(String contenu);

    // Trouver une note par utilisateur
    Note findByUser(User user);

    // Trouver toutes les notes d'un utilisateur par son pseudoname
    List<Note> findByUserPseudoname(String pseudoname);  
      List<user> findByEmail(String email);

}

public User findByEmail(String email);

}

