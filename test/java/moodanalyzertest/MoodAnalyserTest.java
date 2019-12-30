package moodanalyzertest;

import com.bridgelabz.MoodAnalyser;
import com.bridgelabz.MoodAnalyzerReflector;
import com.bridgelabz.exception.MoodCustomException;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
        MoodAnalyser moodAnalyzer = MoodAnalyzerReflector.createMoodAnalyzer("Enter valid message");
        String mood = moodAnalyzer.analyze();
        Assert.assertEquals("Happy",mood);
    }

    @Test
    public void whenGivenObjectWithProperMessage_shouldReturnTrue() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am Happy");
        MoodAnalyser moodAnalyser1 = MoodAnalyzerReflector.createMoodAnalyzer("I am Happy");
        Assert.assertEquals(true,moodAnalyser1.equals(moodAnalyser));
    }

    @Test
    public void whenImproperClassName_shouldReturnException() {
        try {
            Constructor <?> constructor=Class.forName("com.bridgelabz.MoodAnalyse").getConstructor(String.class);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw  new MoodCustomException(MoodCustomException.ExceptionType.No_SUCH_METHOD_FOUND,"Enter Valid message");
        } catch (ClassNotFoundException e) {
            try {
                throw new MoodCustomException(MoodCustomException.ExceptionType.No_SUCH_CLASS_FOUND, "Enter Valid message");
            }
            catch (MoodCustomException a) {
                a.printStackTrace();
            }
        }
    }

    @Test
    public void whenImproperMethodName_shouldReturnException() {
        try {
            Constructor<?>constructor=Class.forName("com.bridgelabz.MoodAnalyser").getConstructor();
            } catch (NoSuchMethodException e) {

            try {
                throw new MoodCustomException(MoodCustomException.ExceptionType.No_SUCH_METHOD_FOUND, "Enter Valid Method name");
            }catch (Exception aa)
            {
                aa.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenGivenConstructorWithParameter_shouldReturnObject() {
        Constructor<?> constructor = MoodAnalyzerReflector.getConstructor(String.class);
        Object object = MoodAnalyzerReflector.getObject(constructor,"i am happy");
        MoodAnalyser moodAnalyser = (MoodAnalyser)object;
        Assert.assertEquals(true,moodAnalyser.equals(new MoodAnalyser("i am happy")));
    }

    @Test
    public void whenGivenConstructorWithNoParameter_shouldReturnObject() {
        Constructor<?> constructor = MoodAnalyzerReflector.getConstructor();
        Object object = MoodAnalyzerReflector.getObject(constructor);
        MoodAnalyser moodAnalyser = (MoodAnalyser)object;
        Assert.assertEquals(true,moodAnalyser.equals(new MoodAnalyser()));
    }

    @Test
    public void whenInvokeMethod_shouldCorrect() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am sad");
        Class cls = moodAnalyser.getClass();
        try {
            Method method = cls.getMethod("analyze");
            Object object =method.invoke(moodAnalyser);
            Assert.assertEquals("Sad",object.toString());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void whenGivenMethod_shouldInvokeReturnObject() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = MoodAnalyzerReflector.getMethod("i am happy");
        String mood = (String) method.invoke(new MoodAnalyser("i am happy"));
        Assert.assertEquals("Happy",mood);
    }


    @Test
    public void whenGivenMethodNameNotProper_shouldInvokeReturnObject() throws InvocationTargetException, IllegalAccessException {
        try {
            Method method = MoodAnalyzerReflector.getIncorrectMethod("analys");
            String mood = (String) method.invoke(new MoodAnalyser("i am happy"));
            Assert.assertEquals("Happy", mood);
        }
        catch (MoodCustomException e) {
            e.printStackTrace();
        }

    }

}