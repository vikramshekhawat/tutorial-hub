package com.example.helloworldapi.repository;

import com.example.helloworldapi.entity.Technology;
import com.example.helloworldapi.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByTechnologyOrderByStepNumberAsc(Technology technology);
    long countByTechnology(Technology technology);
}

