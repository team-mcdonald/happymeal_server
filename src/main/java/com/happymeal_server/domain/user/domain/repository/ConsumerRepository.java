package com.happymeal_server.domain.user.domain.repository;

import com.happymeal_server.domain.user.domain.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Consumer, Long> {
}
