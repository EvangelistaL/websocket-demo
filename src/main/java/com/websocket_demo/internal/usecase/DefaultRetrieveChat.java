package com.websocket_demo.internal.usecase;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.dto.ChatDTO;
import com.websocket_demo.api.repository.ChatRepository;
import com.websocket_demo.api.usecase.RetrieveChat;
import com.websocket_demo.internal.utils.ChatDtoToChatUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveChat implements RetrieveChat {

    private final ChatRepository chatRepository;

    @Override
    public Page<ChatDTO> execute(Pageable pageable, Predicate predicate) {
        if (predicate == null){
            return this.chatRepository.findAll(pageable).map(ChatDtoToChatUtils::transform);
        }
        return this.chatRepository.findAll(predicate, pageable).map(ChatDtoToChatUtils::transform);
    }

    @Override
    public ChatDTO execute(Predicate predicate) {
        return ChatDtoToChatUtils.transform(this.chatRepository.findOne(predicate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)));
    }
}
