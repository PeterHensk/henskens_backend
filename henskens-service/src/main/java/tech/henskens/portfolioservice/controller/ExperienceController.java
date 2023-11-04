package tech.henskens.portfolioservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.henskens.portfolioservice.service.ExperienceService;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

}
