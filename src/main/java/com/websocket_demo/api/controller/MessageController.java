package com.websocket_demo.api.controller;

import com.websocket_demo.api.dto.MessageDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/message")
public interface MessageController {

    @MessageMapping(value = "/send-message/{chatId}")
    @SendToUser("/topic/messages")
    MessageDTO sendMessage(@Payload MessageDTO message, @DestinationVariable Long chatId);

    @GetMapping(path = "/retrieve-message/{chatId}")
    @ResponseStatus(HttpStatus.OK)
    Page<MessageDTO> retrieveMessagesByChat(Pageable pageable, @PathVariable Long id);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMessage(@PathVariable Long id);
}
