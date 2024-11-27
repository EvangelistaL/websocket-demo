package com.websocket_demo.api.usecase;

import com.websocket_demo.api.dto.UserDTO;

public interface UpdateUser {

    UserDTO execute(UserDTO userDTO);
}
