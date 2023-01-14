package com.happymeal_server.domain.question.service;

import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.domain.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
