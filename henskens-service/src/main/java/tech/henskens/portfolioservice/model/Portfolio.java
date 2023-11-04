package tech.henskens.portfolioservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Portfolio {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    @Id
    private String id;

    @Field
    @NotNull
    private String applicationName;

    @Field
    @NotNull
    private String url;

    @Field
    @NotNull
    private LocalDate projectDate;

    @Field
    @NotNull
    private String longDescription;

    @Field
    private List<PortfolioImage> images;

    @Field
    private List<Comment> comments = new ArrayList<>();


}
