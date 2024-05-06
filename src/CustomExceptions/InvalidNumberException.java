package CustomExceptions;

public class InvalidNumberException extends Exception
{
    public InvalidNumberException(String message, int value)
    {
        super("CustomExceptions.InvalidNumberException - " + message + ": Error value: " + value);
    }
}
