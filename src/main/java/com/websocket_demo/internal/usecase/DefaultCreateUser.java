package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.dto.UserDTO;
import com.websocket_demo.api.entity.User;
import com.websocket_demo.api.repository.UserRepository;
import com.websocket_demo.api.usecase.CreateUser;
import com.websocket_demo.internal.utils.UserDtoToUserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultCreateUser implements CreateUser {

    private final UserRepository userRepository;

    @Override
    public List<UserDTO> execute(List<UserDTO> user) {
        List<User> usersConverted = user.stream()
                .map(UserDtoToUserUtils::transform)
                .toList();
        return this.userRepository.saveAll(usersConverted).stream()
                .map(UserDtoToUserUtils::transform)
                .toList();
    }
}
