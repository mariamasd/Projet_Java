package com.example.notomatic.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String pseudoname;

    private String password;

    @OneToOne(mappedBy = "user")
    private Note note;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPseudoname() {
        return this.pseudoname;
    }

    public void setPseudoname(String pseudoname) {
        this.pseudoname = pseudoname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Note getNote() {
        return this.note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public User(Long id, String email, String pseudoname, String password, Note note) {
        this.id = id;
        this.email = email;
        this.pseudoname = pseudoname;
        this.password = password;
        this.note = note;
    }

    public User() {
    }
    
}
