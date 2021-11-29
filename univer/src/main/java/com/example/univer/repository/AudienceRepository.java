package com.example.univer.repository;

import com.example.univer.model.Audience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudienceRepository extends JpaRepository<Audience, Long> {
    Audience findByNumberAud(Integer integer);
}
