package com.websocket_demo.internal.utils;

import com.websocket_demo.api.dto.MessageDTO;
import com.websocket_demo.api.entity.Message;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageDtoToMessageUtils {

    public static Message transform(MessageDTO messageDTO){
        Message message = new Message();
        message.setId(messageDTO.id());
        message.setMessage(messageDTO.message());
        message.setTimeStamp(messageDTO.timeStamp());
        return message;
    }

    public static MessageDTO transform(Message message){
        return new MessageDTO(message.getId(), message.getMessage(), message.getTimeStamp());
    }
}
