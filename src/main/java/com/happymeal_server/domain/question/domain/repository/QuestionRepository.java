package com.happymeal_server.domain.question.domain.repository;

import com.happymeal_server.domain.question.domain.Question;
import com.happymeal_server.domain.question.domain.type.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByCategory(Category category);
}
