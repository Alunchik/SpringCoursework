package com.Alekperova.CourseWork.exceptions;

public class ObjectNotFonudException extends Exception{
    public ObjectNotFonudException(String message){
        super("Object not found - " + message);
    }
}
