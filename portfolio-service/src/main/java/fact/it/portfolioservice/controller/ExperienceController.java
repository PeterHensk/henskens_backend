package fact.it.portfolioservice.controller;

import fact.it.portfolioservice.dto.ExperienceRequest;
import fact.it.portfolioservice.dto.ExperienceResponse;
import fact.it.portfolioservice.service.ExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

