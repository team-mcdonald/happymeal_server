package com.happymeal_server.domain.question.domain.repository;

import com.happymeal_server.domain.question.domain.Like;
import com.happymeal_server.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    Optional<Like> findByIdAndUser(Long id, User user);
}
