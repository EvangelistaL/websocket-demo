package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.entity.Chat;
import com.websocket_demo.api.repository.ChatRepository;
import com.websocket_demo.api.specification.ChatSpecification;
import com.websocket_demo.api.usecase.DeleteChat;
import com.websocket_demo.api.usecase.RetrieveChat;
import com.websocket_demo.internal.utils.ChatDtoToChatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDeleteChat implements DeleteChat {

    private final RetrieveChat retrieveChat;

    private final ChatRepository chatRepository;

    @Override
    public void execute(Long id) {
        Chat chat = ChatDtoToChatUtils.transform(this.retrieveChat.execute(ChatSpecification.findById(id)));
        this.chatRepository.delete(chat);
    }
}
