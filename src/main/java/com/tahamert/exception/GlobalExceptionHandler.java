package com.tahamert.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = { MethodArgumentNotValidException.class })
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, List<String>> errorsMap = new HashMap<>();


            for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
                String fieldName = fieldError.getField();


                if (errorsMap.containsKey(fieldName)) {
                    errorsMap.get(fieldName).add(fieldError.getDefaultMessage());
                }
                else {
                    List<String> errors = new ArrayList<>();
                    errors.add(fieldError.getDefaultMessage());
                    errorsMap.put(fieldName, errors);

                }


        }
            return ResponseEntity.badRequest().body(buildApiError(errorsMap));



    }
    private <T> ApiError<T> buildApiError(T errors) {
        ApiError apiError = new ApiError();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);
        return apiError;
    }

}
