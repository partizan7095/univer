package com.example.univer.repository;

import com.example.univer.model.StudentGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<StudentGroup, Long> {
    Optional<StudentGroup> findByGroupNumber(String groupNumber);

    StudentGroup findById(StudentGroup studentGroup);
}
