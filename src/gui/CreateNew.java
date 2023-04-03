package gui;

import javax.swing.*;

public class CreateNew
{

    protected CreateNew()
    {
        Screen.appName = new JTextField();
        Screen.goSend = new JButton();
        Screen.goUser = new JButton();
        Screen.goTerminal = new JButton();
        Screen.goSettings = new JButton();

        Screen.settingsHeader = new JTextField();
        Screen.infoRow = new JTextField();
        Screen.langList = new JComboBox<>();
        Screen.changeLang = new JButton();
        Screen.changeTheme = new JButton();
        Screen.resetData = new JButton();

        Screen.back = new JButton();
    }

}
