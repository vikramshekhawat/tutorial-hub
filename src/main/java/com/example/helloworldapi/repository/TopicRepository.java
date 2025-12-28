package com.example.helloworldapi.repository;

import com.example.helloworldapi.entity.Topic;
import com.example.helloworldapi.entity.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    List<Topic> findByTutorialOrderByTopicNumberAsc(Tutorial tutorial);
}

