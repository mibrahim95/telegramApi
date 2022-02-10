package com.mojo.telegramAPIValidator;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    public CustomException() {}

    public CustomException(String message) {
        super(message);
    }
}

