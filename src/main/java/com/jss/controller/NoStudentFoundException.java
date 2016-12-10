package com.jss.controller;

/**
 * Created by Jack on 10.12.2016.
 */
public class NoStudentFoundException extends Exception {
    public NoStudentFoundException(String message) {
        super(message);
    }
}
