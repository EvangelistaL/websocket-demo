package com.websocket_demo.internal.utils;

import com.websocket_demo.api.dto.ChatDTO;
import com.websocket_demo.api.entity.Chat;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class ChatDtoToChatUtils {

    public static Chat transform(ChatDTO chatDTO){
        Chat chat = new Chat();
        chat.setId(chatDTO.id());
        chat.setChatName(chat.getChatName());
        chat.setCreatedDate(chatDTO.createdDate());
        chat.setMessages(chatDTO.messages().stream()
                .map(MessageDtoToMessageUtils::transform)
                .toList());
        chat.setInvolved(chatDTO.involved().stream()
                .map(UserDtoToUserUtils::transform)
                .collect(Collectors.toSet()));
        return chat;
    }

    public static ChatDTO transform(Chat chat){
        return new ChatDTO(chat.getId(),
                chat.getChatName(),
                chat.getCreatedDate(),
                chat.getInvolved().stream()
                        .map(UserDtoToUserUtils::transform)
                        .toList(),
                chat.getMessages().stream()
                        .map(MessageDtoToMessageUtils::transform)
                        .toList());
    }
}
