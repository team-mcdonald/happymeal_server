package com.happymeal_server.domain.question.presentaion;

import com.happymeal_server.domain.question.domain.dto.QuestionDto;
import com.happymeal_server.domain.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
