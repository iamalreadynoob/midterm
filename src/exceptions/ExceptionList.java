package exceptions;

import database.Communicator;
import database.Language;

import java.util.ArrayList;

public class ExceptionList extends Communicator
{

    private ArrayList<String> exceptions, script;

    protected ExceptionList()
    {
        super("data/lang/" + new Language().getLanguage() + ".txt");

        exceptions = new ArrayList<>();
        script = read();

        userExceptions();
    }

    protected ArrayList<String> getExceptions() {return exceptions;}

    private void userExceptions()
    {
        exceptions.add(script.get(27));
        exceptions.add(script.get(28));
        exceptions.add(script.get(29));
        exceptions.add(script.get(30));
        exceptions.add(script.get(31));
        exceptions.add(script.get(32));
        exceptions.add(script.get(34));
        exceptions.add(script.get(35));
    }

}
