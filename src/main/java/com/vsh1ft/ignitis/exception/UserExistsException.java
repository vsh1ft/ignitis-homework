package com.vsh1ft.ignitis.exception;

public final class UserExistsException extends RuntimeException {

    public UserExistsException() {
        super("User already exists");
    }

}
