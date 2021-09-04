package com.epam.jwd.exception;

import java.io.IOException;

public class WriteDataException extends IOException {
    public WriteDataException(String message) {
        super(message);
    }
}
