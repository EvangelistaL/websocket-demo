package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.dto.ChatDTO;
import com.websocket_demo.api.repository.ChatRepository;
import com.websocket_demo.api.usecase.UpdateChat;
import com.websocket_demo.internal.utils.ChatDtoToChatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultUpdateChat implements UpdateChat {

    private final ChatRepository chatRepository;

    @Override
    public ChatDTO execute(ChatDTO chat) {
        return ChatDtoToChatUtils
                .transform(this.chatRepository.save(ChatDtoToChatUtils.transform(chat)));
    }

}
