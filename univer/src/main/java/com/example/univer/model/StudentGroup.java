package com.example.univer.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StudentGroup {

    @Id
    @GeneratedValue
    Long id;

    @Column(unique = true, nullable = false)
    String groupNumber;

    public StudentGroup() { }

    public StudentGroup(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Long getId() {return id;}

    public String getGroupNumber() {return groupNumber;}

    public void setGroupNumber(String groupNumber) {this.groupNumber = groupNumber;}

}

