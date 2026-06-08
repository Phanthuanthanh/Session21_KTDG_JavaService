package com.example.base_spring_boot.advice;

import com.example.base_spring_boot.exceptions.HttpBadRequestException;
import com.example.base_spring_boot.exceptions.HttpNotFoundException;
import com.example.base_spring_boot.models.dtos.wrapper.DataRes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling
{
    /**
     * @param ex MethodArgumentNotValidException
     * @apiNote handle valid exception for validation (400)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidException(MethodArgumentNotValidException ex)
    {
        Map<String, String> errors = new HashMap<>();
        ex.getFieldErrors().forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                DataRes.builder()
                        .data(errors)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST)
                        .build()
        );
    }

    /**
     * @param ex NoResourceFoundException
     * @apiNote handle exception not found resource (404)
     * */
    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handleNoResourceFoundException(NoResourceFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                DataRes.builder()
                        .data(ex.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .status(HttpStatus.NOT_FOUND)
                        .build()
        );
    }

    /**
     * @param ex UsernameNotFoundException
     * @apiNote handle username not found exception
     * */
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> handleUsernameNotFoundException(UsernameNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                DataRes.builder()
                        .data(ex.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .status(HttpStatus.NOT_FOUND)
                        .build()
        );
    }

    /**
     * @param ex HttpBadRequest
     * @apiNote handle exception bad request (400)
     * */
    @ExceptionHandler(HttpBadRequestException.class)
    public ResponseEntity<?> handleHttpBadReqeust(HttpBadRequestException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                DataRes.builder()
                        .data(ex.getMessage())
                        .code(HttpStatus.BAD_REQUEST.value())
                        .status(HttpStatus.BAD_REQUEST)
                        .build()
        );
    }

    /**
     * @param ex HttpNotFound
     * @apiNote handle exception not found (404)
     * */
    @ExceptionHandler(HttpNotFoundException.class)
    public ResponseEntity<?> handleHttpNotFound(HttpNotFoundException ex)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                DataRes.builder()
                        .data(ex.getMessage())
                        .code(HttpStatus.NOT_FOUND.value())
                        .status(HttpStatus.NOT_FOUND)
                        .build()
        );
    }

}