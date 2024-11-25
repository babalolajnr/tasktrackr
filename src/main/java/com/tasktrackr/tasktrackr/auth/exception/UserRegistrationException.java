
package com.tasktrackr.tasktrackr.auth.exception;

public class UserRegistrationException extends RuntimeException {
    private final String field;

    public UserRegistrationException(String message, String field) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}