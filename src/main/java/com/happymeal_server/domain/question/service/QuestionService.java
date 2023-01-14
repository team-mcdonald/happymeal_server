package com.happymeal_server.domain.question.service;

import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.domain.repository.QuestionRepository;
import com.happymeal_server.domain.question.domain.ro.GetQuestionRo;
import com.happymeal_server.domain.question.domain.type.Category;
import com.happymeal_server.global.error.exception.QuestionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Transactional
    public void makeQuestion(QuestionDto dto) {
        // TODO Consumer 인지 확인하는 로직
//        if (user.role != UserRole.CONSUMER) {
//
//        }

        Question question = Question.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .category(dto.getCategory())
//                .user(user)
                .build();

        questionRepository.save(question);
    }

    public List<GetQuestionRo> getQuestions() {

        return questionRepository.findAll().stream().map(GetQuestionRo::convertRo).collect(Collectors.toList());
    }

    public List<GetQuestionRo> getQuestionByCategory(Category category) {
        return questionRepository.findAllByCategory(category).stream().map(GetQuestionRo::convertRo).collect(Collectors.toList());
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> {
            throw QuestionNotFoundException.EXCEPTION;
        });
    }
}
