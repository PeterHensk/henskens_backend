package tech.henskens.experienceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceResponse {
    private String id;
    private String title;
    private String description;
    private LocalDate published;
    private String projectUrl;
}
