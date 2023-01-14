package com.happymeal_server.domain.question.service;

import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.domain.repository.QuestionRepository;
import com.happymeal_server.domain.question.domain.type.Category;
import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.global.error.exception.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Transactional
    public void makeQuestion(QuestionDto dto, User user) {
        Question question = Question.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .category(dto.getCategory())
                .user(user)
                .build();

        questionRepository.save(question);
    }

    public List<Question> getQuestions() {

        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(Category category) {
        return questionRepository.findAllByCategory(category);
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> {
            throw QuestionNotFoundException.EXCEPTION;
        });
    }
}
