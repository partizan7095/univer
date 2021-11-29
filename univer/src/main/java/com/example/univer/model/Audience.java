package com.example.univer.model;

import javax.persistence.*;

@Entity
public class Audience {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true)
    int numberAud;

    public Audience() {}

    public Audience(Integer numberAud) {
        this.numberAud = numberAud;
    }

    public Long getId() {
        return id;
    }

    public int getNumberAud() {
        return numberAud;
    }

    public void setNumberAud(int numberAud) {
        this.numberAud = numberAud;
    }
}
