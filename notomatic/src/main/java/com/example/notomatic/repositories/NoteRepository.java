package com.example.notomatic.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.notomatic.models.Note;
import com.example.notomatic.models.User;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    // Recherche de notes par titre et utilisateur
    List<Note> findByTitleAndUser(String title, User user);

    // Recherche de notes par utilisateur
    List<Note> findByUser(User user);

    // Suppression de notes par titre
    void deleteByTitle(String title);

    // Recherche de notes par contenu
    List<Note> findByContenu(String contenu);

    // Recherche de notes par titre contenant une chaîne
    List<Note> findByTitleContaining(String keyword);

    // Ajoutez ici d'autres méthodes personnalisées en fonction de vos besoins
}
