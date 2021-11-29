package com.example.univer.controller;

import com.example.univer.model.Schedule;
import com.example.univer.model.Student;
import com.example.univer.repository.StudentRepository;
import com.example.univer.service.ScheduleService;
import com.example.univer.service.StudentService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("univer/students")
public class StudentController {
    private final StudentService studentService;
    private final ScheduleService scheduleService;

    public StudentController(StudentService studentService,ScheduleService scheduleService, StudentRepository studentRepository) {
        this.studentService = studentService;
        this.scheduleService = scheduleService;
        this.studentRepository = studentRepository;
    }
    private final StudentRepository studentRepository;

    @GetMapping(path = "list")
    public List<Student> listStudent(){
        return studentService.list();
    }
    @GetMapping(path = "list/{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.get(id);
    }

    @GetMapping(path = "list_schedule_lesson/{id}")
    public List<Schedule> scheduleLesson(@PathVariable Long id,
                                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") Date date){
        return studentService.getLesson(id, date);
    }

    @PostMapping(path = "item")
    public List<Student> addStudent(@RequestBody Student student){
        studentService.add(student);
        return studentService.list();
    }
    @DeleteMapping(path = "item/{studentId}")
    public void deleteStudent(@PathVariable Long studentId){
        studentService.delete(studentId);
    }

    @PutMapping(path = "item/{studentId}")
    public void updateStudent(@PathVariable Long studentId, @RequestBody Student student){
        studentService.update(studentId, student);
    }
}
