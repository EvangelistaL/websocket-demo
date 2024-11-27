package com.websocket_demo.internal.controller;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.controller.UserController;
import com.websocket_demo.api.dto.UserDTO;
import com.websocket_demo.api.specification.UserSpecification;
import com.websocket_demo.api.usecase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnSingleCandidate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@ConditionalOnSingleCandidate(UserController.class)
public class DefaultUserController implements UserController {

    private final CreateUser createUser;

    private final DeleteUser deleteUser;

    private final RetrieveUsers retrieveUsers;

    private final UpdateUser updateUser;

    @Override
    public List<UserDTO> createUsers(List<UserDTO> users) {
        return this.createUser.execute(users);
    }

    @Override
    public Page<UserDTO> retrieveUsers(Pageable pageable, Predicate predicate) {
        return this.retrieveUsers.execute(pageable, predicate);
    }

    @Override
    public UserDTO retrieveUserById(Long id) {
        return this.retrieveUsers.execute(UserSpecification.findById(id));
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return this.updateUser.execute(userDTO);
    }

    @Override
    public void deleteUser(Long id) {
        this.deleteUser.execute(id);
    }
}
