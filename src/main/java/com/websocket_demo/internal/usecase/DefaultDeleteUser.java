package com.websocket_demo.internal.usecase;

import com.websocket_demo.api.entity.User;
import com.websocket_demo.api.repository.UserRepository;
import com.websocket_demo.api.specification.UserSpecification;
import com.websocket_demo.api.usecase.DeleteUser;
import com.websocket_demo.api.usecase.RetrieveUsers;
import com.websocket_demo.internal.utils.UserDtoToUserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultDeleteUser implements DeleteUser {

    private final UserRepository userRepository;

    private final RetrieveUsers retrieveUsers;

    @Override
    public void execute(Long id) {
        User user = UserDtoToUserUtils
                .transform(retrieveUsers.execute(UserSpecification.findById(id)));
        this.userRepository.delete(user);
    }
}
