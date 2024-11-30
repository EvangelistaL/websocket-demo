package com.websocket_demo.api.usecase;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.dto.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveMessage {

    Page<MessageDTO> execute(Pageable pageable, Predicate predicate);

    MessageDTO execute(Predicate predicate);
}
