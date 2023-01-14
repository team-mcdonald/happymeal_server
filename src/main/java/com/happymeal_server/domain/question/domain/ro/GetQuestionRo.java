package com.happymeal_server.domain.question.domain.ro;

import com.happymeal_server.domain.question.domain.Answer;
import com.happymeal_server.domain.question.domain.Like;
import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.type.Category;
import com.happymeal_server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class GetQuestionRo {
    private Long id;
    private String title;
    private String content;
    private User user;
    private Category category;
    private List<Like> likes;
    private List<Answer> answers;

    public static GetQuestionRo convertRo(Question question) {
        return new GetQuestionRo(
                question.getId(),
                question.getTitle(),
                question.getContent(),
                question.getUser(),
                question.getCategory(),
                question.getLikes(),
                question.getAnswers()
        );
    }
}
