package com.example.helloworldapi.controller;

import com.example.helloworldapi.dto.TechnologyDTO;
import com.example.helloworldapi.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutorials")
@CrossOrigin(origins = "http://localhost:3000")
public class TutorialController {

    @Autowired
    private TutorialService tutorialService;

    @GetMapping("/technologies")
    public ResponseEntity<List<TechnologyDTO>> getAllTechnologies() {
        List<TechnologyDTO> technologies = tutorialService.getAllTechnologies();
        return ResponseEntity.ok(technologies);
    }

    @GetMapping("/technologies/{id}")
    public ResponseEntity<TechnologyDTO> getTechnologyById(@PathVariable Long id) {
        try {
            TechnologyDTO technology = tutorialService.getTechnologyById(id);
            return ResponseEntity.ok(technology);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

