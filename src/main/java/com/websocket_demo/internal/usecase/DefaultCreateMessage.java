package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.dto.MessageDTO;
import com.websocket_demo.api.exception.MethodNotImplementedException;
import com.websocket_demo.api.usecase.CreateMessage;
import org.springframework.stereotype.Service;

@Service
public class DefaultCreateMessage implements CreateMessage {

    @Override
    public MessageDTO execute(MessageDTO message, Long chatId) {
        throw new MethodNotImplementedException();
    }
}
