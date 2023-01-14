package com.happymeal_server.domain.article.domain;

import com.happymeal_server.domain.article.domain.type.ArticleType;
import com.happymeal_server.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "article")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "article_type")
    @Enumerated(value = EnumType.STRING)
    private ArticleType articleType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "article", fetch = FetchType.LAZY)
    private List<ArticleLike> articleLikes;
}
