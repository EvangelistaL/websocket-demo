package com.websocket_demo.api.specification;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.entity.QChat;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ChatSpecification {

    private static final QChat qChat = QChat.chat;

    public static Predicate findById(Long id){
        return qChat.id.eq(id);
    }
}
