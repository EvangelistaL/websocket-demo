package com.websocket_demo.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.server.ResponseStatusException;

public class MethodNotImplementedException extends ResponseStatusException {

    private static final String MESSAGE = "Method not implemented";

    private static final int STATUS = 422;

    public MethodNotImplementedException() {
        super(HttpStatus.valueOf(STATUS), MESSAGE);
    }
}
