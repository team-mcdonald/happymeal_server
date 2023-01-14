package com.happymeal_server.domain.question.presentaion;

import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.domain.ro.GetQuestionRo;
import com.happymeal_server.domain.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<GetQuestionRo>> getQuestion() {
        return ResponseEntity.ok(questionService.getQuestions());
    }
}
