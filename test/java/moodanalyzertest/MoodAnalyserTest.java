package moodanalyzertest;

import com.bridgelabz.MoodAnalyser;
import com.bridgelabz.exception.MoodCustomException;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest
{
    @Test
    public void whenGivenSad_ShouldReturnSad() {
         MoodAnalyser moodAnalyser = new MoodAnalyser();
         String message= moodAnalyser.analyze("I am sad right now");
         Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenHappy_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String message= moodAnalyser.analyze("I am happy right now.");
        Assert.assertEquals("Happy",message);

    }

    @Test
    public void whenGivenSadMessageWithAlphabetCapital_shouldRetunSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String message= moodAnalyser.analyze("I am Sad right now");
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenAMoodNull_should_ReturnInvalid() {
        try {
           // ExpectedException exceptionRule=ExpectedException.none();
            //exceptionRule.expect(MoodCustomException.class);
            MoodAnalyser moodAnalyser = new MoodAnalyser();
            String message = moodAnalyser.analyze(null);
            Assert.assertEquals("Sad", message);
        }catch (MoodCustomException e)
        {
          //  e.printStackTrace(); its show the message
            Assert.assertEquals("Enter valid message",e.getMessage());
            System.out.println(e.getMessage());
        }

    }
}