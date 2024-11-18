package com.websocket_demo.api.controller;

import com.websocket_demo.api.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/users")
public interface UserController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    List<UserDTO> createUsers(@RequestBody List<UserDTO> users);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<UserDTO> retrieveUsers(Pageable pageable);

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    UserDTO retrieveUserById(@PathVariable Long id);

    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    UserDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id);

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteUser(@PathVariable Long id);
}
