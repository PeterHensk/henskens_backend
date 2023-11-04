package tech.henskens.portfolioservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Comment {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Field
    @NotNull
    private String commendTitle;

    @Field
    @NotNull
    private String commentText;

    @Field
    private LocalDateTime postDate;

    @Field
    @NotNull
    private Account account;

}
