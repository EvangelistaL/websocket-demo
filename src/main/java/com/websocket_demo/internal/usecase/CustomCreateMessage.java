package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.dto.MessageDTO;
import com.websocket_demo.api.entity.Chat;
import com.websocket_demo.api.entity.Message;
import com.websocket_demo.api.repository.MessageRepository;
import com.websocket_demo.api.specification.ChatSpecification;
import com.websocket_demo.api.usecase.CreateMessage;
import com.websocket_demo.api.usecase.RetrieveChat;
import com.websocket_demo.internal.utils.ChatDtoToChatUtils;
import com.websocket_demo.internal.utils.MessageDtoToMessageUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@ConditionalOnSingleCandidate(CreateMessage.class)
public class CustomCreateMessage extends DefaultCreateMessage{

    private final MessageRepository messageRepository;

    private final RetrieveChat retrieveChat;

    public CustomCreateMessage(MessageRepository messageRepository, RetrieveChat retrieveChat) {
        super();
        this.messageRepository = messageRepository;
        this.retrieveChat = retrieveChat;
    }

    @Override
    public MessageDTO execute(MessageDTO message, Long chatId) {
        Message messageConverted = MessageDtoToMessageUtils.transform(message);
        messageConverted.setChat(retrieveChat(chatId));
        messageConverted.setTimeStamp(LocalDateTime.now());
        return MessageDtoToMessageUtils.transform(this.messageRepository.save(messageConverted));
    }

    private Chat retrieveChat(Long chatId){
        return ChatDtoToChatUtils.transform(retrieveChat.execute(ChatSpecification.findById(chatId)));
    }
}
