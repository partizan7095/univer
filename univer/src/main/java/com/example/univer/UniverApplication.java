package com.example.univer;

import com.example.univer.model.Audience;
import com.example.univer.model.Schedule;
import com.example.univer.model.Student;
import com.example.univer.model.StudentGroup;
import com.example.univer.service.AudienceService;
import com.example.univer.service.GroupService;
import com.example.univer.service.ScheduleService;
import com.example.univer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class UniverApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(UniverApplication.class, args);
    }
    @Autowired
    StudentService studentService;
    @Autowired
    GroupService groupService;
    @Autowired
    AudienceService audienceService;
    @Autowired
    ScheduleService scheduleService;

    @Override
    public void run(String[] args) throws Exception{
        Audience aud101 = new Audience(108);
        Audience aud102 = new Audience(107);
        Audience aud103 = new Audience(110);
        Audience aud104 = new Audience(112);
        StudentGroup gh208 = new StudentGroup("gh208");
        StudentGroup gh207 = new StudentGroup("gh207");
        StudentGroup gh209 = new StudentGroup("gh209");
        StudentGroup gh210 = new StudentGroup("gh210");
        Student eduard = new Student("eduard@gmail.com", "Eduard", LocalDate.of(1996,8,26), gh208);
        Student olha = new Student("olha@gmail.com", "Olha", LocalDate.of(1990,3,21), gh207);
        Student zlata = new Student("zlata@gmail.com", "Zlata", LocalDate.of(2014, 7,30), gh209);
        Student vitya = new Student("vitya@gmail.com", "Vitya", LocalDate.of(2000,12,31), gh210);
        Schedule br101Sche = new Schedule(Arrays.asList("English", "Math"), gh208, aud101, LocalDate.of(2021, 12, 1));
        Schedule br103Sche = new Schedule(Arrays.asList("Chemistry", "Diagram"), gh207, aud103, LocalDate.of(2021, 12, 2));
        Schedule br104Sche = new Schedule(Arrays.asList("Programing", "Math"), gh209, aud104, LocalDate.of(2021, 12, 3));
        Schedule br102Sche = new Schedule(Arrays.asList("Ukraine", "Physic"), gh210, aud102, LocalDate.of(2021,12,4));

        audienceService.addAud(aud101);
        audienceService.addAud(aud102);
        audienceService.addAud(aud103);
        audienceService.addAud(aud104);
        groupService.addGroup(gh208);
        groupService.addGroup(gh207);
        groupService.addGroup(gh209);
        groupService.addGroup(gh210);
        studentService.add(eduard);
        studentService.add(olha);
        studentService.add(zlata);
        studentService.add(vitya);
        scheduleService.add(br101Sche);
        scheduleService.add(br102Sche);
        scheduleService.add(br103Sche);
        scheduleService.add(br104Sche);

    }
}
