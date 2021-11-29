package com.example.univer.service;

import com.example.univer.model.Schedule;
import com.example.univer.model.Student;
import com.example.univer.repository.ScheduleRepository;
import com.example.univer.repository.StudentRepository;
import com.example.univer.responce.RestApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    private final ScheduleRepository scheduleRepository;
    @Autowired
    private ScheduleService scheduleService;

    public StudentService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Student> list(){
         return studentRepository.findAll();
}

    public void add(Student student) {
        if(studentRepository.findStudentByEmail(student.getEmail()).isPresent()){
            throw new RestApiException("Email is busy");
        }
        studentRepository.save(student);
    }

    public void delete(Long studentId) {
        studentRepository.delete(studentRepository.getById(studentId));
    }

    public void update(Long studentId, Student student) {
        Optional<Student> studentOptional = studentRepository.findById(studentId);
        if(studentOptional.isPresent()){
            Student item = studentOptional.get();
            if(!student.getName().isEmpty()){
                item.setName(student.getName());
            }if(student.getDob() != null){
                item.setDob(student.getDob());
            }if(student.getStudentGroup() != null){
                item.setStudentGroup(student.getStudentGroup());
            }if(!student.getEmail().isEmpty()){
                item.setEmail(student.getEmail());
            }
            studentRepository.save(item);
        }
    }

    public List<Schedule> getLesson(Long studentId, Date date) {
        LocalDate localDate = LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date));
        List<Schedule> scheduleFromGroup = scheduleService.getScheduleFromGroup(studentRepository.findById(studentId).get().getStudentGroup());


        return scheduleFromGroup.stream().filter(schedule -> schedule.getDateSchedule().equals(localDate)).collect(Collectors.toList());
    }

    public Optional<Student> get(Long id) {
        return studentRepository.findById(id);
    }
}
