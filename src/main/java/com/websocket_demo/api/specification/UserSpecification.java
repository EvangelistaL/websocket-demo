package com.websocket_demo.api.specification;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.entity.QUser;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserSpecification {

    private static final QUser qUser = QUser.user;

    public static Predicate findById(Long id){
        return qUser.id.eq(id);
    }
}
