package com.example.univer.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long scheduleId;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> lesson;

    @OneToOne
    private StudentGroup studentGroups;

    @OneToOne
    private Audience audiences;

    private LocalDate dateSchedule;

    public Schedule() { }

    public Schedule(List<String> lesson, StudentGroup studentGroups, Audience audiences, LocalDate localDate) {
        this.lesson = lesson;
        this.dateSchedule = localDate;
        this.studentGroups = studentGroups;
        this.audiences = audiences;
    }

    public Audience getAudiences() {return audiences;}

    public void setAudiences(Audience audiences) {this.audiences = audiences;}

    public StudentGroup getStudentGroups() {return studentGroups;}

    public LocalDate getDateSchedule() {
        return dateSchedule;
    }

    public void setDateSchedule(LocalDate dateSchedule) {
        this.dateSchedule = dateSchedule;
    }

    public void setStudentGroups(StudentGroup studentGroups) {
        this.studentGroups = studentGroups;}

    public Long getScheduleId() {
        return scheduleId;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", lesson=" + lesson +
                ", studentGroups=" + studentGroups +
                ", audiences=" + audiences +
                ", dateSchedule=" + dateSchedule +
                '}';
    }

    public List<String> getLesson() {
        return lesson;
    }

    public void setLesson(List<String> lesson) {
        this.lesson = lesson;
    }
}
