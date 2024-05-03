public class InvalidNumberException extends Exception
{
    public InvalidNumberException(String message, int value)
    {
        super("InvalidNumberException - " + message + ": Error value: " + value);
    }
}
