package com.Alekperova.CourseWork.exceptions;

public class NotEnoughAmountException extends Exception{
    public NotEnoughAmountException(String message) {
        super("Not enough amount - " + message);
    }
}
