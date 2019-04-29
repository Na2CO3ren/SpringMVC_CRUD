package com.robin.springmvc.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SelfExceptionHandler {

    @ExceptionHandler({ArithmeticException.class})
    public String handleException(Exception ex) {
        System.out.println("--->" + ex.getMessage());
        return "success";
    }
}
