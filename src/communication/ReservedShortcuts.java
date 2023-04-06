package communication;

import java.util.ArrayList;

public class ReservedShortcuts
{

    private ArrayList<String> commands;

    protected ReservedShortcuts()
    {
        commands = new ArrayList<>();
        fill();
    }

    protected boolean isCommand(String text)
    {
        boolean isCmd = false;

        for (String cmd: commands)
        {
            if (text.startsWith(cmd))
            {
                isCmd = true;
                break;
            }
        }

        return isCmd;
    }

    private void fill()
    {
        commands.add("/test");
        commands.add("/roblox");
    }

}
