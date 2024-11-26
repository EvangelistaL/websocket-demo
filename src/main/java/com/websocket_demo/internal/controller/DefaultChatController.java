package com.websocket_demo.internal.controller;

import com.websocket_demo.api.controller.ChatController;
import com.websocket_demo.api.dto.ChatDTO;
import com.websocket_demo.api.specification.ChatSpecification;
import com.websocket_demo.api.usecase.CreateChat;
import com.websocket_demo.api.usecase.DeleteChat;
import com.websocket_demo.api.usecase.RetrieveChat;
import com.websocket_demo.api.usecase.UpdateChat;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(ChatController.class)
public class DefaultChatController implements ChatController{

    private final CreateChat createChat;

    private final DeleteChat deleteChat;

    private final RetrieveChat retrieveChat;

    private final UpdateChat updateChat;

    @Override
    public ChatDTO createChat(ChatDTO chat) {
        return this.createChat.execute(chat);
    }

    @Override
    public ChatDTO retrieveChatById(Long id) {
        return this.retrieveChat.execute(ChatSpecification.findById(id));
    }

    @Override
    public ChatDTO updateChat(ChatDTO chat) {
        return this.updateChat.execute(chat);
    }

    @Override
    public void deleteChat(Long id) {
        this.deleteChat.execute(id);
    }
}
