package com.happymeal_server.domain.article.service;

import com.happymeal_server.domain.article.domain.Article;
import com.happymeal_server.domain.article.domain.ArticleRepository;
import com.happymeal_server.domain.article.domain.dto.ArticleDto;
import com.happymeal_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public void createArticle(ArticleDto dto, User user) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .articleType(dto.getArticleType())
                .user(user)
                .build();

        articleRepository.save(article);
    }
}
