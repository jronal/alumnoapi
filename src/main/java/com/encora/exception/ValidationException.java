package com.encora.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = false)
@Data
@ToString
public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String message;

    public ValidationException(String message) {
        super(message);
        this.message = message;
    }

}
