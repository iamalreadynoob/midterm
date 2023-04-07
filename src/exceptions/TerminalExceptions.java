package exceptions;

public class TerminalExceptions
{

    private String error;

    public TerminalExceptions(int code)
    {
        error = null;

        switch (code)
        {
            case 6: error = new ExceptionList().getExceptions().get(6); break;
            case 7: error = new ExceptionList().getExceptions().get(7); break;
        }

    }

    public String getError() {return error;}
}