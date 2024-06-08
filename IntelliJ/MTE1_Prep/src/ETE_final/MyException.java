package ETE_final;
public class MyException extends Exception
    //every single exception extends the main exception class
{
    public MyException(String message)
    {
        //constructor
        super(message);
    }
}
