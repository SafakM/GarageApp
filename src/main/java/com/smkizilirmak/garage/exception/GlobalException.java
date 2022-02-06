package com.smkizilirmak.garage.exception;

import com.smkizilirmak.garage.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GarageApiException.class)
    public ResponseEntity<ErrorDto> handleGarageException(GarageApiException exception, WebRequest req){
        ErrorDto errorDto= new ErrorDto(new Date(),exception.getMessage(),req.getDescription(false));
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }
}
