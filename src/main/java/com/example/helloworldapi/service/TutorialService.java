package com.example.helloworldapi.service;

import com.example.helloworldapi.dto.TechnologyDTO;
import com.example.helloworldapi.entity.Technology;
import com.example.helloworldapi.repository.TechnologyRepository;
import com.example.helloworldapi.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorialService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Autowired
    private TutorialRepository tutorialRepository;

    @PostConstruct
    public void initDefaultTechnologies() {
        if (technologyRepository.count() == 0) {
            // Create default technologies
            Technology java = new Technology("Java", 
                "Learn Java programming from basics to advanced concepts including OOP, Collections, Streams, and more.");
            java.setIconUrl("☕");
            technologyRepository.save(java);

            Technology ai = new Technology("AI", 
                "Explore Artificial Intelligence, Machine Learning, Deep Learning, and Neural Networks.");
            ai.setIconUrl("🤖");
            technologyRepository.save(ai);

            Technology aws = new Technology("AWS", 
                "Master Amazon Web Services including EC2, S3, Lambda, CloudFormation, and cloud architecture.");
            aws.setIconUrl("☁️");
            technologyRepository.save(aws);
        }
    }

    public List<TechnologyDTO> getAllTechnologies() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologies.stream()
                .map(tech -> {
                    Long tutorialCount = tutorialRepository.countByTechnology(tech);
                    return new TechnologyDTO(
                        tech.getId(),
                        tech.getName(),
                        tech.getDescription(),
                        tech.getIconUrl(),
                        tutorialCount
                    );
                })
                .collect(Collectors.toList());
    }

    public TechnologyDTO getTechnologyById(Long id) {
        Technology technology = technologyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Technology not found"));
        Long tutorialCount = tutorialRepository.countByTechnology(technology);
        return new TechnologyDTO(
            technology.getId(),
            technology.getName(),
            technology.getDescription(),
            technology.getIconUrl(),
            tutorialCount
        );
    }
}

