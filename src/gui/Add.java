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

        frame.add(Screen.userHeader);
        frame.add(Screen.nameSection);
        frame.add(Screen.surnameSection);
        frame.add(Screen.emailSection);
        frame.add(Screen.exceptionSection);
        frame.add(Screen.priorityList);
        frame.add(Screen.singleMail);
        frame.add(Screen.userList);
        frame.add(Screen.addUser);
        frame.add(Screen.removeUser);

        frame.add(Screen.terminalHeader);
        frame.add(Screen.cmdArea);
        frame.add(Screen.terminalHelp);

        frame.add(Screen.sendHeader);
        frame.add(Screen.specificReceiver);
        frame.add(Screen.from);
        frame.add(Screen.to);
        frame.add(Screen.mailText);
        frame.add(Screen.sendMail);
        frame.add(Screen.senderList);
        frame.add(Screen.receiverList);

        frame.add(Screen.back);
    }

}