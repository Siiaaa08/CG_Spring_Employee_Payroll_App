
package com.example.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@ControllerAdvice
public class EmployeePayrollExceptionClass {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponseClass> handleMethod(MethodArgumentNotValidException exception) {
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.toList());

        ErrorResponseClass response = new ErrorResponseClass("Validation Failed", errMsg);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    //for id exception
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ErrorResponseClass> handleEmployeeId(EmployeeNotFound exception){
        ErrorResponseClass response=new ErrorResponseClass("Employee not found",List.of(exception.getMessage()));
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    private static final List<String> message= new ArrayList<>();

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponseClass> handleHttp(HttpMessageNotReadableException exception){
        log.error("Invalid Date Formate",exception);
        message.add("Exception while processing REST Request");
        ErrorResponseClass responseClass=new ErrorResponseClass("Should have date in right formate",message ) ;
        return new ResponseEntity<ErrorResponseClass>(responseClass,HttpStatus.BAD_REQUEST);
    }
}
