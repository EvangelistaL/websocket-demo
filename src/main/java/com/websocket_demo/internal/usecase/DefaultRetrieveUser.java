package com.websocket_demo.internal.usecase;

import com.querydsl.core.types.Predicate;
import com.websocket_demo.api.dto.UserDTO;
import com.websocket_demo.api.repository.UserRepository;
import com.websocket_demo.api.usecase.RetrieveUser;
import com.websocket_demo.internal.utils.UserDtoToUserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class DefaultRetrieveUser implements RetrieveUser {

    private final UserRepository userRepository;

    @Override
    public Page<UserDTO> execute(Pageable pageable, Predicate predicate) {
        if (predicate == null){
            return this.userRepository.findAll(pageable).map(UserDtoToUserUtils::transform);
        }
        return this.userRepository.findAll(predicate, pageable).map(UserDtoToUserUtils::transform);
    }

    @Override
    public UserDTO execute(Predicate predicate) {
        return UserDtoToUserUtils.transform(this.userRepository.findOne(predicate)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)));
    }
}
