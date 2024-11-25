package com.websocket_demo.api.usecase;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.dto.ChatDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveChat {

    Page<ChatDTO> execute(Pageable pageable, Predicate predicate);

    ChatDTO execute(Predicate predicate);
}
