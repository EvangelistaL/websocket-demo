package com.websocket_demo.api.specification;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.entity.QMessage;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MessageSpecification {

    private static final QMessage qMessage = QMessage.message1;

    public static Predicate findById(Long id){
        return qMessage.id.eq(id);
    }
}
