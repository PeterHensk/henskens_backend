package tech.henskens.experienceservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Document(value = "experience")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Experience {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
    private String id;
    private String title;
    private String description;
    private LocalDate published;
    private String projectUrl;
    private LocalDateTime updateTimestamp;
}
