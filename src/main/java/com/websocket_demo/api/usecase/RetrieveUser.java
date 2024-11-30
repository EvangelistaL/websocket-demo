package com.websocket_demo.api.usecase;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RetrieveUser {

    Page<UserDTO> execute(Pageable pageable, Predicate predicate);

    UserDTO execute(Predicate predicate);
}
