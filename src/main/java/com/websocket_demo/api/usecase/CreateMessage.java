package com.websocket_demo.api.usecase;

import com.websocket_demo.api.dto.MessageDTO;

public interface CreateMessage {

    MessageDTO execute(MessageDTO message, Long chatId);
}
