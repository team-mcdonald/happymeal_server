package com.happymeal_server.domain.article.domain.dto;

import com.happymeal_server.domain.article.domain.type.ArticleType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ArticleDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    private ArticleType articleType;
}
