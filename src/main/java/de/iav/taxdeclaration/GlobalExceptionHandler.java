package de.iav.taxdeclaration;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    Map<String, Object> handleBindException(BindException e) {
        Map<String, Object> errorMessage = new HashMap<>();
        errorMessage.put("reason", e.getMessage());
        errorMessage.put("timestamp", Instant.now());
        errorMessage.put("getAllErrors(): ", e.getAllErrors());
        return errorMessage;
    }
}
