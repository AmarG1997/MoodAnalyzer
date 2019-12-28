package moodanalyzertest;

import com.bridgelabz.MoodAnalyser;
import com.bridgelabz.MoodAnalyzerFactory;
import com.bridgelabz.exception.MoodCustomException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest
{
    @Test
    public void whenGivenSad_ShouldReturnSad() {
         MoodAnalyser moodAnalyser = new MoodAnalyser("I am sad right now");
         String message= moodAnalyser.analyze();
         Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenHappy_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am happy right now.");
        String message= moodAnalyser.analyze();
        Assert.assertEquals("Happy",message);

    }

    @Test
    public void whenGivenSadMessageWithAlphabetCapital_shouldRetunSad() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am Sad right now");
        String message= moodAnalyser.analyze();
        Assert.assertEquals("Sad",message);
    }

    @Test
    public void whenGivenAMoodNull_should_ReturnInvalid() {
        try {
           // ExpectedException exceptionRule=ExpectedException.none();
            //exceptionRule.expect(MoodCustomException.class);
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            String message = moodAnalyser.analyze();
            Assert.assertEquals("Sad", message);
        }catch (MoodCustomException e)
        {
          //  e.printStackTrace(); its show the message
            Assert.assertEquals("Enter valid message",e.getMessage());
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void givenMoodAnalyserObject_whenProper_shouldReturnObject() {

        try {
            Constructor<?> constructor = Class.forName("com.bridgelabz.MoodAnalyser").getConstructor(String.class);
            Object myObj = constructor.newInstance("i'm in happy mood");
            MoodAnalyser moodAnalyser = (MoodAnalyser) myObj;

                try
                {
                    String mood = moodAnalyser.analyze();
                    Assert.assertEquals("Happy",mood);
            }catch (MoodCustomException e)
            {
                e.printStackTrace();
            }

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void givenMoodAnalyserClass_whenProper_shouldReturnObject() {
        MoodAnalyser moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzer("Enter valid message");
        String mood = moodAnalyzer.analyze();
        Assert.assertEquals("Happy",mood);
    }

    @Test
    public void whenGivenObjectWithProperMessage_shouldReturnTrue() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am Happy");
        MoodAnalyser moodAnalyser1 = MoodAnalyzerFactory.createMoodAnalyzer("I am Happy");
        Assert.assertEquals(true,moodAnalyser1.equals(moodAnalyser));
    }
}