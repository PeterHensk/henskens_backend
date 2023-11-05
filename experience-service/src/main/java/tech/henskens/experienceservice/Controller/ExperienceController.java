package tech.henskens.experienceservice.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tech.henskens.experienceservice.dto.ExperienceRequest;
import tech.henskens.experienceservice.dto.ExperienceResponse;
import tech.henskens.experienceservice.service.ExperienceService;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceService experienceService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createExperience
            (@RequestBody ExperienceRequest experienceRequest) {
        experienceService.createExperience(experienceRequest);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ExperienceResponse> getAllExperiences() {
        return experienceService.getAllExperiences();
    }
}
