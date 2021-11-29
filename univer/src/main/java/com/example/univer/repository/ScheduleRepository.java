package com.example.univer.repository;

import com.example.univer.model.Schedule;
import com.example.univer.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByStudentGroups(StudentGroup studentGroup);
}
