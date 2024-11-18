package com.websocket_demo.api.controller;

import com.websocket_demo.api.dto.MessageDTO;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/message")
public interface MessageController {

    @MessageMapping(value = "/send-message/{chatId}")
    @SendToUser("/topic/messages")
    MessageDTO sendMessage(@Payload MessageDTO message, @DestinationVariable Long chatId);
}
