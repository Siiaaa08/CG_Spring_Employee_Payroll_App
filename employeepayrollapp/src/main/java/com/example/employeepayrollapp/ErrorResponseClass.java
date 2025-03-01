package com.example.employeepayrollapp;

import java.util.List;

    public class ErrorResponseClass {
        private String message;
        private List<String> details;

        public ErrorResponseClass(String message, List<String> details) {
            this.message = message;
            this.details = details;
        }

        public String getMessage() {
            return message;
        }

        public List<String> getDetails() {
            return details;
        }
    }


