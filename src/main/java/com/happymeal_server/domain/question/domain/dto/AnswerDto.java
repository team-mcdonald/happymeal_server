package com.happymeal_server.domain.question.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AnswerDto {

    @NotBlank
    private String answer;

}
