package gui;

import javax.swing.*;

public class Screen extends JFrame
{
    //main frame
    protected static JTextField appName;
    protected static JButton goSend, goUser, goTerminal, goSettings;

    //settings frame
    protected static JTextField settingsHeader, infoRow;
    protected static JComboBox<String> langList;
    protected static JButton changeLang, changeTheme, resetData;

    //common
    protected static JButton back;

    public Screen()
    {
        this.setSize(600, 400);
        this.setLayout(null);
        this.setTitle("communicator");

        new CreateNew();
        new Add(this);
        new Visibility().hide();
        new Theme(this);
        new AppText();
        new Buttons();
        new Positions();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
