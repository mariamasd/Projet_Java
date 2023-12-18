package com.example.notomatic.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contenu;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getcontenu() {
        return this.contenu;
    }

    public void setcontenu(String contenu) {
        this.contenu = contenu;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note(Long id, String title, String contenu, User user) {
        this.id = id;
        this.title = title;
        this.contenu = contenu;
        this.user = user;
    }

    public Note() {
    }
    
}

