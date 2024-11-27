package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.dto.ChatDTO;
import com.websocket_demo.api.entity.Chat;
import com.websocket_demo.api.repository.ChatRepository;
import com.websocket_demo.api.usecase.CreateChat;
import com.websocket_demo.internal.utils.ChatDtoToChatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultCreateChat implements CreateChat {

    private final ChatRepository chatRepository;

    @Override
    public ChatDTO execute(ChatDTO chat) {
        Chat chatConverted = ChatDtoToChatUtils.transform(chat);
        return ChatDtoToChatUtils.transform(this.chatRepository.save(chatConverted));
    }
}
