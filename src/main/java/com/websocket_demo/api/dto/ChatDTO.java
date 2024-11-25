package com.websocket_demo.api.dto;

import com.websocket_demo.api.entity.Message;

import java.time.LocalDateTime;
import java.util.List;

public record ChatDTO(Long id,
                      String chatName,
                      LocalDateTime createdDate,
                      List<UserDTO> involved,
                      List<MessageDTO> messages) {
}
