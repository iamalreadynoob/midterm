package terminal;

import java.util.ArrayList;

public class Parser
{
    private String command, text;
    private ArrayList<String> arguments;
    protected Parser(String text)
    {
        this.text = text;

        command = null;
        arguments = new ArrayList<>();

        find();
    }

    public ArrayList<String> getArguments() {return arguments;}

    public String getCommand() {return command;}

    private void find()
    {
        Integer lastCommand = null;

        for (int i = 0; i < text.length(); i++)
        {
            if (text.charAt(i) == '/') lastCommand = i;
        }

        if (lastCommand != null)
        {
            int loc = lastCommand;

            while (loc < text.length() && text.charAt(loc) != ' ')
            {
                if (command == null) command = Character.toString(text.charAt(loc));
                else command += Character.toString(text.charAt(loc));

                loc++;
            }

            while (loc < text.length())
            {

                if (text.charAt(loc) == '\"')
                {
                    loc++;
                    String arg = null;

                    while (loc < text.length() && text.charAt(loc) != '\"')
                    {
                        if (arg == null) arg = Character.toString(text.charAt(loc));
                        else arg += Character.toString(text.charAt(loc));

                        loc++;
                    }

                    arguments.add(arg);
                }

                loc++;
            }
        }
    }



}
