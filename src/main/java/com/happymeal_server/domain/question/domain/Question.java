package com.happymeal_server.domain.question.domain;

import com.happymeal_server.domain.question.domain.type.Category;
import com.happymeal_server.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "questin")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Like> likes;

    @OneToMany(mappedBy = "question", fetch = FetchType.LAZY)
    private List<Answer> answers;
}
