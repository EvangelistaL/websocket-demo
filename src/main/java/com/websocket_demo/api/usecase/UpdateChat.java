package com.websocket_demo.api.usecase;

import com.websocket_demo.api.dto.ChatDTO;

public interface UpdateChat {

    ChatDTO execute(ChatDTO chat);
}
