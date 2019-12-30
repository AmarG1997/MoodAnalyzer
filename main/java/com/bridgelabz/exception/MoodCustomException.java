package com.bridgelabz.exception;

public class MoodCustomException extends RuntimeException{

    public enum ExceptionType
    {
        ENTERED_NULL,ENTERED_EMPTY,No_SUCH_METHOD_FOUND,No_SUCH_CLASS_FOUND,NO_SUCH_FIELD_FOUND;


    }
    ExceptionType type;

    public MoodCustomException(ExceptionType type , String message)
    {
        super(message);
        this.type=type;
    }
}
