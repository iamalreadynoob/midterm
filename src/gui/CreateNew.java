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

        Screen.userHeader = new JTextField();
        Screen.nameSection = new JTextField();
        Screen.surnameSection = new JTextField();
        Screen.emailSection = new JTextField();
        Screen.exceptionSection = new JTextField();
        Screen.priorityList = new JComboBox<>();
        Screen.userList = new JComboBox<>();
        Screen.addUser = new JButton();
        Screen.singleMail = new JButton();
        Screen.removeUser = new JButton();

        Screen.terminalHeader = new JTextField();
        Screen.cmdArea = new JTextArea();
        Screen.terminalHelp = new JButton();

        Screen.sendHeader = new JTextField();
        Screen.specificReceiver = new JTextField();
        Screen.from = new JTextField();
        Screen.to = new JTextField();
        Screen.mailText = new JTextArea();
        Screen.sendMail = new JButton();
        Screen.senderList = new JComboBox<>();
        Screen.receiverList = new JComboBox<>();

        Screen.back = new JButton();
    }

}
