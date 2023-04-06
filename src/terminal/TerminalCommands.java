package terminal;

import java.util.ArrayList;

public class TerminalCommands
{

    private ArrayList<String> commands;

    protected TerminalCommands()
    {
        commands = new ArrayList<>();
        fill();
    }

    protected ArrayList<String> getCommands(){return commands;}

    private void fill()
    {
        commands.add("/help");
        commands.add("/clear");
        commands.add("/send");
        commands.add("/info");
        commands.add("/list");
        commands.add("/export");
        commands.add("/import");
        commands.add("/close");
        commands.add("/time");
        commands.add("/suggest");
        commands.add("/floppy-disk");
        commands.add("/???");
        commands.add("/anime-girls-are-real");
        commands.add("/share");
    }

}
