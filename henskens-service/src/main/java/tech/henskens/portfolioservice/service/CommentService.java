package tech.henskens.portfolioservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tech.henskens.portfolioservice.model.Account;
import tech.henskens.portfolioservice.model.Comment;
import tech.henskens.portfolioservice.model.Portfolio;
import tech.henskens.portfolioservice.repository.AccountRepository;
import tech.henskens.portfolioservice.repository.PortfolioRepository;

import java.time.LocalDateTime;

import static tech.henskens.portfolioservice.model.Comment.generateId;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final PortfolioRepository portfolioRepository;
    private final AccountRepository accountRepository;

    public void createDefaultComment() {
        Comment comment1 = new Comment();
        comment1.setId(generateId());
        comment1.setCommendTitle("a first comment about something");
        comment1.setCommentText("a long tekst about that comment");
        comment1.setPostDate(LocalDateTime.now());
        Account account1 = accountRepository.findById("user1").orElse(null);
        comment1.setAccount(account1);

        Comment comment2 = new Comment();
        comment2.setId(generateId());
        comment2.setCommendTitle("a 2nd comment about something");
        comment2.setCommentText("a long tekst about that comment");
        comment2.setPostDate(LocalDateTime.now());
        Account account2 = accountRepository.findById("user2").orElse(null);
        comment2.setAccount(account2);

        Portfolio portfolio = portfolioRepository.findById("portfolioID1").orElse(null);

        if (portfolio != null) {
            portfolio.getComments().add(comment1);
            portfolio.getComments().add(comment2);
            portfolioRepository.save(portfolio);
        }

    }
}

