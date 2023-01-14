package com.happymeal_server.domain.article.presentation;

import com.happymeal_server.domain.article.domain.dto.ArticleDto;
import com.happymeal_server.domain.article.service.ArticleService;
import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.domain.types.UserRole;
import com.happymeal_server.global.annotation.AuthenticationCheck;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @PostMapping("/")
    @AuthenticationCheck(roles = UserRole.PROVIDER)
    public int createArticle(@Valid @RequestBody ArticleDto dto, @RequestAttribute User user) {
        articleService.createArticle(dto, user);

        return 200;
    }
}
