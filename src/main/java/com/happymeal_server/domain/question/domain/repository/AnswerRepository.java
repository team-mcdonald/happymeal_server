package com.happymeal_server.domain.question.domain.repository;

import com.happymeal_server.domain.question.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
