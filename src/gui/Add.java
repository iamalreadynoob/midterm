package gui;

import javax.swing.*;

public class Add
{

    protected Add(JFrame frame)
    {
        frame.add(Screen.appName);
        frame.add(Screen.goSend);
        frame.add(Screen.goUser);
        frame.add(Screen.goTerminal);
        frame.add(Screen.goSettings);

        frame.add(Screen.settingsHeader);
        frame.add(Screen.infoRow);
        frame.add(Screen.langList);
        frame.add(Screen.changeLang);
        frame.add(Screen.changeTheme);
        frame.add(Screen.resetData);

        frame.add(Screen.back);
    }

}
