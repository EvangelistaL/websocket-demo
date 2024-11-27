package com.websocket_demo.api.usecase;

import com.websocket_demo.api.dto.UserDTO;

import java.util.List;

public interface CreateUser {

    List<UserDTO> execute(List<UserDTO> user);
}
