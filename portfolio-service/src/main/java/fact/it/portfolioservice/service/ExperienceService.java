package fact.it.portfolioservice.service;

import fact.it.portfolioservice.dto.ExperienceRequest;
import fact.it.portfolioservice.dto.ExperienceResponse;
import fact.it.portfolioservice.model.Experience;
import fact.it.portfolioservice.repository.ExperienceRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;
    private static final Logger logger = LoggerFactory.getLogger(fact.it.portfolioservice.service.ExperienceService.class);

    @PostMapping
    public void loadData(){
        logger.info("Loading data...");
//        if (experienceRepository.count() < 3) {
        Experience experience = new Experience();
        experience.setId(Experience.generateId());
        experience.setTitle("My first app");
        experience.setDescription("dit was mijn eerste app, gemaakt in thomasmore het bevat Anglular en firebase code");
        experience.setPublished(LocalDate.now());
        experience.setUpdateTimestamp(LocalDateTime.now());
        experienceRepository.save(experience);

        Experience experience2 = new Experience();
        experience2.setId(Experience.generateId());
        experience2.setTitle("My 2nd app");
        experience2.setDescription("dit was mijn tweede app, gemaakt in thomasmore het bevat React en supabase code");
        experience2.setPublished(LocalDate.now());
        experience2.setUpdateTimestamp(LocalDateTime.now());
        experienceRepository.save(experience);
        logger.info("Data loading completed.");
//        }
    }

    public void createExperience(ExperienceRequest experienceRequest){
        Experience experience = fact.it.portfolioservice.model.Experience.builder()
                .title(experienceRequest.getTitle())
                .description(experienceRequest.getDescription())
                .published(experienceRequest.getPublished())
                .projectUrl(experienceRequest.getProjectUrl())
                .build();

        experienceRepository.save(experience);
    }

    public List<ExperienceResponse> getAllExperiences() {
        List<Experience> experiences = experienceRepository.findAll();

        return experiences.stream().map(this::mapToExperienceResponse).toList();
    }


    private ExperienceResponse mapToExperienceResponse(Experience experience) {
        return ExperienceResponse.builder()
                .id(experience.getId())
                .title(experience.getTitle())
                .description(experience.getDescription())
                .published(experience.getPublished())
                .projectUrl(experience.getProjectUrl())
                .build();
    }
}
