package com.happymeal_server.domain.question.domain.repository;

import com.happymeal_server.domain.question.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository  extends JpaRepository<Question, Long> {
}
