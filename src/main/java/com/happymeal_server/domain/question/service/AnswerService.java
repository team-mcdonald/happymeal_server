package com.happymeal_server.domain.question.service;


import com.happymeal_server.domain.question.domain.Answer;
import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.dto.AnswerDto;
import com.happymeal_server.domain.question.domain.repository.AnswerRepository;
import com.happymeal_server.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final QuestionService questionService;

    public void createAnswer(AnswerDto answerDto, Long questionId, User user) {
        Question question = questionService.getQuestionById(questionId);

        Answer answer = Answer.builder()
                .comment(answerDto.getAnswer())
                .user(user)
                .question(question)
                .build();

        answerRepository.save(answer);
    }
}