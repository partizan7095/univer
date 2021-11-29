package com.example.univer.controller;

import com.example.univer.model.Audience;
import com.example.univer.model.Schedule;
import com.example.univer.model.Student;
import com.example.univer.model.StudentGroup;
import com.example.univer.service.AudienceService;
import com.example.univer.service.GroupService;
import com.example.univer.service.ScheduleService;
import com.example.univer.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentControllerTest {

    @Autowired
    StudentService studentService;
    @Autowired
    GroupService groupService;
    @Autowired
    ScheduleService scheduleService;
    @Autowired
    AudienceService audienceService;
    @Test
    void listStudent() {
        Student eduard = new Student("eduard@gmail.com", "Eduard", LocalDate.now(), null);
        Student olha = new Student("olha@gmail.com", "Olha",
                LocalDate.of(1990,03,21), null);
        studentService.add(eduard);
        studentService.add(olha);
        Assert.isTrue(studentService.list().size()==2);
        studentService.delete(eduard.getId());
        studentService.delete(olha.getId());
    }

    @Test
    void scheduleLesson() {
        Audience aud101 = new Audience(108);
        Audience aud102 = new Audience(107);
        StudentGroup gh208 = new StudentGroup("gh208");
        Student eduard = new Student("vitya@gmail.com", "Vitya", LocalDate.now(), gh208);
        Schedule br101Sche = new Schedule(Arrays.asList("English", "Math"), gh208, aud101, LocalDate.of(2021, 12, 1));
        Schedule br102Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), gh208, aud102, LocalDate.of(2021,12,2));

        audienceService.addAud(aud101);
        audienceService.addAud(aud102);
        groupService.addGroup(gh208);
        studentService.add(eduard);
        scheduleService.add(br101Sche);
        scheduleService.add(br102Sche);

        Assert.isTrue(scheduleService.getList().size()==2);
        List<String> lesson = Arrays.asList("English", "Math");
        Assert.isTrue(lesson.containsAll(scheduleService.get(br101Sche.getScheduleId()).get().getLesson()));
        scheduleService.delete(br101Sche.getScheduleId());
        scheduleService.delete(br102Sche.getScheduleId());
        studentService.delete(eduard.getId());
        audienceService.delete(aud101.getId());
        audienceService.delete(aud102.getId());
        groupService.delete(gh208.getId());
    }

    @Test
    void addStudent() {
        Student eduard = new Student("eduard@gmail.com", "Eduard", LocalDate.now(), null);
        Student zlata = new Student("zlata@gmail.com", "Zlata", LocalDate.now(), null);
        Student olha = new Student("olha@gmail.com", "Olha",
                LocalDate.of(1990,03,21), null);
        studentService.add(eduard);
        studentService.add(olha);
        Assert.isTrue(studentService.list().size()==2);
        studentService.add(zlata);
        Assert.isTrue(studentService.list().size()==3);
        studentService.delete(eduard.getId());
        studentService.delete(olha.getId());
        studentService.delete(zlata.getId());
    }

    @Test
    void deleteStudent() {
        Student eduard = new Student("eduard@gmail.com", "Eduard", LocalDate.now(), null);
        Student zlata = new Student("zlata@gmail.com", "Zlata", LocalDate.now(), null);
        Student olha = new Student("olha@gmail.com", "Olha",
                LocalDate.of(1990,03,21), null);
        studentService.add(eduard);
        studentService.add(olha);
        Assert.isTrue(studentService.list().size()==2);
        studentService.add(zlata);
        Assert.isTrue(studentService.list().size()==3);
        studentService.delete(zlata.getId());
        Assert.isTrue(studentService.list().size()==2);
        studentService.delete(eduard.getId());
        studentService.delete(olha.getId());
    }

    @Test
    void updateStudent() {
        Student eduard = new Student("eduard1@gmail.com", "Eduard", LocalDate.now(), null);
        Student zlata = new Student("zlata1@gmail.com", "Zlata", LocalDate.now(), null);
        Student olha = new Student("olha1@gmail.com", "Olha",
                LocalDate.of(1990,03,21), null);
        studentService.add(eduard);
        studentService.add(olha);
        Assert.isTrue(studentService.list().size()==2);
        studentService.add(zlata);
        Assert.isTrue(studentService.list().size()==3);
        Student test = zlata;
        test.setDob(LocalDate.of(2000,01,01));
        studentService.update(zlata.getId(), test);
        Assert.isTrue(studentService.get(test.getId()).get().getDob().equals(LocalDate.of(2000,01,01)));
        studentService.delete(eduard.getId());
        studentService.delete(olha.getId());
        studentService.delete(zlata.getId());
    }
}