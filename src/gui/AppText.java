package gui;

import database.Communicator;
import database.Language;

import java.util.ArrayList;

public class AppText extends Communicator implements IFrames
{
    ArrayList<String> script;
    protected AppText()
    {
        super("data/lang/" + new Language().getLanguage() + ".txt");
        script = read();

        mainFrame();
        sendFrame();
        userFrame();
        terminalFrame();
        settingsFrame();
        back();
    }

    @Override
    public void mainFrame()
    {
        Screen.goSend.setText(script.get(0));
        Screen.goUser.setText(script.get(1));
        Screen.goTerminal.setText(script.get(2));
        Screen.goSettings.setText(script.get(3));
    }

    @Override
    public void sendFrame()
    {

    }

    @Override
    public void userFrame()
    {

    }

    @Override
    public void terminalFrame()
    {

    }

    @Override
    public void settingsFrame()
    {
        Screen.settingsHeader.setText(script.get(3).toUpperCase());
        for (int i = 4; i < 10; i++) Screen.langList.addItem(script.get(i));
        Screen.changeLang.setText(script.get(10));
        Screen.changeTheme.setText(script.get(11));
        Screen.resetData.setText(script.get(12));

        ArrayList<String> details = credits();
        Screen.infoRow.setText(script.get(14) + ": " + details.get(0) + "\t" + script.get(15) + " " + details.get(1));
    }

    @Override
    public void back()
    {
        Screen.back.setText(script.get(13));
    }
}
