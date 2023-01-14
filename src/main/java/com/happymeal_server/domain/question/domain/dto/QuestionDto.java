package com.happymeal_server.domain.question.domain.dto;

import com.happymeal_server.domain.question.domain.Category;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class QuestionDto {

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    //    @NotBlank
    private Category category;
}
