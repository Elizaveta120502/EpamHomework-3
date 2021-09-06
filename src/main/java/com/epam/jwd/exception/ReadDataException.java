package com.epam.jwd.exception;


import com.epam.jwd.logger.LoggerProvider;

import java.io.IOException;

public class ReadDataException extends IOException {
    public ReadDataException(String message) {
       super(message);
    }
}
