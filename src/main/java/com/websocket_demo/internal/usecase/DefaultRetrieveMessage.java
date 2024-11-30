package com.websocket_demo.internal.usecase;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.dto.MessageDTO;
import com.websocket_demo.api.repository.MessageRepository;
import com.websocket_demo.api.usecase.RetrieveMessage;
import com.websocket_demo.internal.utils.MessageDtoToMessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveMessage implements RetrieveMessage {

    private final MessageRepository messageRepository;

    @Override
    public Page<MessageDTO> execute(Pageable pageable, Predicate predicate) {
        if (predicate == null){
            return this.messageRepository.findAll(pageable).map(MessageDtoToMessageUtils::transform);
        }
        return this.messageRepository.findAll(predicate, pageable).map(MessageDtoToMessageUtils::transform);
    }

    @Override
    public MessageDTO execute(Predicate predicate) {
        return MessageDtoToMessageUtils.transform(this.messageRepository.findOne(predicate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
