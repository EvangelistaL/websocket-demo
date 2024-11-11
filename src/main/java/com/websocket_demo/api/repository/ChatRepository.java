package com.websocket_demo.api.repository;

import com.websocket_demo.api.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long>,
        QuerydslPredicateExecutor<Chat> {
}
