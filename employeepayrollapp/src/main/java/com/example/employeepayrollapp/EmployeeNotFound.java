package com.example.employeepayrollapp;

public class EmployeeNotFound extends RuntimeException{
    public EmployeeNotFound(String message){
        super(message);
    }
}

