package gui;

import database.Clients;

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

    //user frame
    protected static JTextField userHeader, nameSection, surnameSection, emailSection, exceptionSection;
    protected static JComboBox<String> priorityList, userList;
    protected static JButton addUser, singleMail, removeUser;

    //terminal frame
    protected static JTextField terminalHeader;
    protected static JTextArea cmdArea;
    protected static JButton terminalHelp;

    //send frame
    protected static JTextField sendHeader, specificReceiver, from, to;
    protected static JTextArea mailText;
    protected static JButton sendMail;
    protected static JComboBox<String> senderList, receiverList;

    //common
    protected static JButton back;

    public Screen(Clients clients)
    {
        this.setSize(600, 400);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("communicator");

        new CreateNew();
        new Add(this);
        new Visibility().hide();
        new Theme(this);
        new AppText(clients);
        new Buttons(clients, this);
        new Positions();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
