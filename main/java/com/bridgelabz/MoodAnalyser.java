package com.bridgelabz;

import com.bridgelabz.exception.MoodCustomException;

public class MoodAnalyser
{

    public String analyze(String message) throws MoodCustomException {
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
