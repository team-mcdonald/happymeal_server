package com.happymeal_server.domain.question.presentaion;

import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.domain.ro.GetQuestionRo;
import com.happymeal_server.domain.question.domain.type.Category;
import com.happymeal_server.domain.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @PostMapping("/")
//    @AuthenticationCheck
    public int makeQuestion(@Valid @RequestBody QuestionDto dto) {
        questionService.makeQuestion(dto);

        return 200;
    }

    @GetMapping("/")
    public List<GetQuestionRo> getQuestion() {
        return questionService.getQuestions();
    }

    @GetMapping("/category")
    public List<GetQuestionRo> getQuestionByCategory(@RequestParam Category category) {
        return questionService.getQuestionByCategory(category);
    }
}
