package com.bridgelabz.exception;

public class MoodCustomException extends RuntimeException{

    public enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY
    }
    ExceptionType type;

    public MoodCustomException(ExceptionType type , String message)
    {
        super(message);
        this.type=type;
    }
}
