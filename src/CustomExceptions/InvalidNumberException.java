package CustomExceptions;

public class InvalidNumberException extends Exception
{
    public InvalidNumberException(String message, int value)
    {
        //This is my custom exception that I tailor to suit the needs of the numerical validation.
        super("CustomExceptions.InvalidNumberException - " + message + ": Error value: " + value + "\n");
    }
}
