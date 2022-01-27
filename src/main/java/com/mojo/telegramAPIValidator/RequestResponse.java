package com.mojo.telegramAPIValidator;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class RequestResponse {

    private boolean success;
    private boolean validEmail;
    private boolean validName;
    private boolean validMessage;
    private String message;
}
