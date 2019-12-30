package com.bridgelabz;

import com.bridgelabz.exception.MoodCustomException;

import java.util.Objects;

public class MoodAnalyser
{
    private String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public MoodAnalyser() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoodAnalyser)) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }



    public String analyze() throws MoodCustomException {
        try {
            if (message.length()==0) {
                throw new MoodCustomException(MoodCustomException.ExceptionType.ENTERED_EMPTY, "Enter valid message");
            }
            if (message.contains("Sad") || message.contains("sad"))
                return "Sad";
            else
                return "Happy";

            }catch (Exception e)
                {
                  //  throw new MoodCustomException("Enter valid message");
                    throw new MoodCustomException(MoodCustomException.ExceptionType.ENTERED_NULL,"Enter valid message");

                }
    }
}
