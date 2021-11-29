package com.example.univer.service;

import com.example.univer.model.Schedule;
import com.example.univer.model.StudentGroup;
import com.example.univer.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    public List<Schedule> getList() {
        return scheduleRepository.findAll();
    }

    public void add(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public void delete(Long id) {
        scheduleRepository.delete(scheduleRepository.getById(id));
    }

    public List<Schedule> update(Schedule schedule) {
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(schedule.getScheduleId());
        if(scheduleOptional.isPresent()){
            Schedule schedule1 = scheduleOptional.get();
            if(schedule.getAudiences()!=null){
                schedule1.setAudiences(schedule.getAudiences());
            }
            if(schedule.getStudentGroups()!=null){
                schedule1.setStudentGroups(schedule.getStudentGroups());
            }
            if(schedule.getLesson()!=null){
                schedule1.setLesson(schedule.getLesson());
            }
            if(schedule.getDateSchedule()!=null){
                schedule1.setDateSchedule(schedule.getDateSchedule());
            }
            scheduleRepository.save(schedule1);
        }

        return scheduleRepository.findAll();
    }

    public List<Schedule> getScheduleFromGroup(StudentGroup studentGroup) {
        return scheduleRepository.findAllByStudentGroups(studentGroup);
    }

    public Optional<Schedule> get(Long scheduleId) {
        return scheduleRepository.findById(scheduleId);
    }
}
