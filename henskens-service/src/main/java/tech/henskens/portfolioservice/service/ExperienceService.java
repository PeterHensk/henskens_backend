package tech.henskens.portfolioservice.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.henskens.portfolioservice.model.Experience;
import tech.henskens.portfolioservice.repository.ExperienceRepository;

import java.time.LocalDate;
import java.time.Month;

@Service
@RequiredArgsConstructor
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    @PostConstruct
    public void loadData() {
        if (experienceRepository.count() == 0) {
            LocalDate startDate1 = LocalDate.of(2013, Month.JANUARY, 1);
            LocalDate EndDate1 = LocalDate.of(2015, Month.DECEMBER, 30);
            Experience experience1 = new Experience();
            experience1.setId("experienceID1");
            experience1.setCompany("Renotect");
            experience1.setJobTitle("Warehouse supervisor");
            experience1.setStartDate(startDate1);
            experience1.setEndDate(EndDate1);
            experience1.setLongDescription("For a company specialized in renovating buildings and removal of asbestos I started as a technician restoring all kinds of electric material. Later on I became the supervisor of all warehouse activity’s within the company.");
            experienceRepository.save(experience1);

            LocalDate startDate2 = LocalDate.of(2016, Month.JANUARY, 1);
            LocalDate EndDate2 = LocalDate.of(2017, Month.JUNE, 30);
            Experience experience2 = new Experience();
            experience2.setId("experienceID2");
            experience2.setCompany("Bleckmann");
            experience2.setJobTitle("Team lead & Purchaser");
            experience2.setStartDate(startDate2);
            experience2.setEndDate(EndDate2);
            experience2.setLongDescription("working in a day shift leading 1 shifts (early and late shit) were in both teams +- 9 - 10 people are working, beside that job I took over a small function within the warehouse to manage facility and consumable purchases.");
            experienceRepository.save(experience2);

        }
    }
}

