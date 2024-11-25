package com.websocket_demo.internal.utils;

import com.websocket_demo.api.dto.UserDTO;
import com.websocket_demo.api.entity.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserDtoToUserUtils {

    public static User transform(UserDTO userDTO){
        User user = new User();
        user.setId(userDTO.id());
        user.setUserName(userDTO.userName());
        return user;
    }

    public static UserDTO transform(User user){
        return new UserDTO(user.getId(), user.getUserName());
    }
}
