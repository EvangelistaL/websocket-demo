package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.entity.Message;
import com.websocket_demo.api.repository.MessageRepository;
import com.websocket_demo.api.specification.MessageSpecification;
import com.websocket_demo.api.usecase.DeleteMessage;
import com.websocket_demo.api.usecase.RetrieveMessage;
import com.websocket_demo.internal.utils.MessageDtoToMessageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDeleteMessage implements DeleteMessage {

    private final MessageRepository messageRepository;

    private final RetrieveMessage retrieveMessage;

    @Override
    public void execute(Long id) {
        Message message = MessageDtoToMessageUtils
                .transform(this.retrieveMessage.execute(MessageSpecification.findById(id)));
        messageRepository.delete(message);
    }
}
