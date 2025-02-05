package com.salon.salon.resources.exceptions;

public class InvalidWhatsappException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InvalidWhatsappException(String message) {
        super(message);
    }
}

