package com.websocket_demo.api.controller;

import com.websocket_demo.api.dto.ChatDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/chat")
public interface ChatController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ChatDTO createChat(@RequestBody ChatDTO chat);

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    ChatDTO retrieveChatById(@PathVariable Long id);

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    ChatDTO updateChat(@RequestBody ChatDTO chat, @PathVariable Long id);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteChat(@PathVariable Long id);
}
