package com.websocket_demo.api.dto;

import java.time.LocalDateTime;

public record MessageDTO(Long id,
                         String message,
                         LocalDateTime timeStamp) {
}
