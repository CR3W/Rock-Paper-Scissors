package rockpaperscissors.Exceptions;

/**
* Exception used when not enough data has been recorded
* by the ThrowRecorder to make an accurate prediction.
* @author CR3W
* @version Object-Oriented Design (CS 151)
*/
public class NotEnoughDataException extends Exception
{
/**
* Constructs a new exception with null as its detail message.
*/
    public NotEnoughDataException()
    {
        super();
    }
    
    /**
* Constructs a new exception with the specified detail message.
* @param message the detail message
*/
    public NotEnoughDataException(String message)
    {
        super(message);
    }
}