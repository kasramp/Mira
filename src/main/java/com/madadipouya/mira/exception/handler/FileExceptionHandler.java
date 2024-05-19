package com.madadipouya.mira.exception.handler;

import com.madadipouya.mira.exception.FileNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class FileExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(FileNotFoundException.class);

    @ExceptionHandler(FileNotFoundException.class)
    private ResponseEntity<?> handleFileNotFound(FileNotFoundException fileNotFoundException) {
        logger.warn(fileNotFoundException.getMessage());
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(value = {IOException.class, Exception.class})
    private ResponseEntity<?> handleUnknownException(Exception exception) {
        logger.warn(exception.getMessage());
        return ResponseEntity.internalServerError().build();
    }
}
