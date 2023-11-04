package tech.henskens.portfolioservice.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.henskens.portfolioservice.model.Portfolio;
import tech.henskens.portfolioservice.repository.PortfolioRepository;

import java.time.LocalDate;
import java.time.Month;

@Service
@RequiredArgsConstructor
public class PortfolioService {
    private final PortfolioRepository portfolioRepository;
    private final CommentService commentService;

    @PostConstruct
    public void loadData() {
        if (portfolioRepository.count() == 0) {
            LocalDate projectDate1 = LocalDate.of(2022, Month.JUNE, 1);
            Portfolio portfolio1 = new Portfolio();
            portfolio1.setId("portfolioID1");
            portfolio1.setApplicationName("Angular web application");
            portfolio1.setUrl("https://webshop-eth.firebaseapp.com/login");
            portfolio1.setLongDescription("some long tekst");
            portfolio1.setProjectDate(projectDate1);
            portfolioRepository.save(portfolio1);

            LocalDate projectDate2 = LocalDate.of(2021, Month.JUNE, 1);
            Portfolio portfolio2 = new Portfolio();
            portfolio2.setId("portfolioID2");
            portfolio2.setApplicationName("ASP .net web application");
            portfolio2.setLongDescription("some long text");
            portfolio2.setProjectDate(projectDate2);
            portfolioRepository.save(portfolio2);
            commentService.createDefaultComment();
        }
    }
}

