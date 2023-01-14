package com.happymeal_server.domain.question.service;

import com.happymeal_server.domain.question.domain.Like;
import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.repository.LikeRepository;
import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.global.error.exception.ExistLikeException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepository likeRepository;
    private final QuestionService questionService;

    public void like(Long questionId, User user) {
        Optional<Like> like = likeRepository.findByIdAndUser(questionId, user);

        if (like.isPresent()) {
            throw ExistLikeException.EXCEPTION;
        }

        Question question = questionService.getQuestionById(questionId);

        Like createLike = Like.builder()
                .question(question)
                .user(user)
                .build();

        likeRepository.save(createLike);
    }
}
