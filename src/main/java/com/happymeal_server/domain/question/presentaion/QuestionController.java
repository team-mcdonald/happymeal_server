package com.happymeal_server.domain.question.presentaion;

import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.dto.AnswerDto;
import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.domain.type.Category;
import com.happymeal_server.domain.question.service.AnswerService;
import com.happymeal_server.domain.question.service.LikeService;
import com.happymeal_server.domain.question.service.QuestionService;
import com.happymeal_server.domain.user.domain.User;
import com.happymeal_server.domain.user.domain.types.UserRole;
import com.happymeal_server.global.annotation.AuthenticationCheck;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final LikeService likeService;

    @PostMapping("/")
//    @AuthenticationCheck(roles = UserRole.CONSUMER)
    public int makeQuestion(@Valid @RequestBody QuestionDto dto) {
        questionService.makeQuestion(dto);

        return 200;
    }

    @GetMapping("/")
    public List<Question> getQuestion() {
        return questionService.getQuestions();
    }

    @GetMapping("/category")
    public List<Question> getQuestionByCategory(@RequestParam Category category) {
        return questionService.getQuestionByCategory(category);
    }

    @PostMapping("/answer")
//    @AuthenticationCheck(roles = UserRole.PROVIDER)
    public int createAnswer(@Valid @RequestBody AnswerDto dto, @RequestParam Long questionId) {
        answerService.createAnswer(dto, questionId);

        return 200;
    }

    @PostMapping("/like")
    @AuthenticationCheck(roles = UserRole.PROVIDER)
    public int like(@RequestParam Long questionId, @RequestAttribute User user) {
        likeService.like(questionId, user);

        return 200;
    }
}
