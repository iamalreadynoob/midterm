package gui;

import database.SaveTypes;
import database.Saves;

import javax.swing.*;
import java.awt.*;

public class Theme implements IFrames
{
    private boolean isDark;
    private Color buttonColor, textColor, headerColor;

    protected Theme(JFrame frame)
    {
        if (new Saves(SaveTypes.THEME).getRequested().equals("dark")) isDark = true;
        else isDark = false;

        detectColor();

        background(frame);
        mainFrame();
        sendFrame();
        userFrame();
        terminalFrame();
        settingsFrame();
        back();
    }

    public void background(JFrame frame)
    {
        if (isDark) frame.getContentPane().setBackground(Color.BLACK);
        else frame.getContentPane().setBackground(Color.WHITE);

    }

    private void detectColor()
    {
        if (isDark)
        {
            buttonColor = Color.RED;
            textColor = Color.BLACK;
            headerColor = Color.WHITE;
        }
        else
        {
            buttonColor = Color.BLACK;
            textColor = Color.WHITE;
            headerColor = Color.BLACK;
        }
    }

    @Override
    public void mainFrame()
    {
        Screen.appName.setForeground(headerColor);

        Screen.goSend.setBackground(buttonColor);
        Screen.goSend.setForeground(textColor);

        Screen.goUser.setBackground(buttonColor);
        Screen.goUser.setForeground(textColor);

        Screen.goTerminal.setBackground(buttonColor);
        Screen.goTerminal.setForeground(textColor);

        Screen.goSettings.setBackground(buttonColor);
        Screen.goSettings.setForeground(textColor);
    }

    @Override
    public void sendFrame()
    {
        Screen.sendHeader.setForeground(headerColor);

        Screen.specificReceiver.setForeground(headerColor);

        Screen.from.setForeground(headerColor);

        Screen.to.setForeground(headerColor);

        Screen.mailText.setBackground(buttonColor);
        Screen.mailText.setForeground(textColor);

        Screen.sendMail.setBackground(buttonColor);
        Screen.sendMail.setForeground(textColor);

        Screen.senderList.setBackground(buttonColor);
        Screen.senderList.setForeground(textColor);

        Screen.receiverList.setBackground(buttonColor);
        Screen.receiverList.setForeground(textColor);
    }

    @Override
    public void userFrame()
    {
        Screen.userHeader.setForeground(headerColor);

        Screen.nameSection.setBackground(buttonColor);
        Screen.nameSection.setForeground(textColor);

        Screen.surnameSection.setBackground(buttonColor);
        Screen.surnameSection.setForeground(textColor);

        Screen.emailSection.setBackground(buttonColor);
        Screen.emailSection.setForeground(textColor);

        Screen.exceptionSection.setForeground(headerColor);

        Screen.priorityList.setBackground(buttonColor);
        Screen.priorityList.setForeground(textColor);

        Screen.userList.setBackground(buttonColor);
        Screen.userList.setForeground(textColor);

        Screen.addUser.setBackground(buttonColor);
        Screen.addUser.setForeground(textColor);

        Screen.singleMail.setBackground(buttonColor);
        Screen.singleMail.setForeground(textColor);

        Screen.removeUser.setBackground(buttonColor);
        Screen.removeUser.setForeground(textColor);
    }

    @Override
    public void terminalFrame()
    {
        Screen.terminalHeader.setForeground(headerColor);

        Screen.cmdArea.setBackground(buttonColor);
        Screen.cmdArea.setForeground(textColor);

        Screen.terminalHelp.setBackground(buttonColor);
        Screen.terminalHelp.setForeground(textColor);
    }

    @Override
    public void settingsFrame()
    {
        Screen.settingsHeader.setForeground(headerColor);
        Screen.infoRow.setForeground(headerColor);
        Screen.langList.setBackground(buttonColor);
        Screen.langList.setForeground(textColor);
        Screen.changeLang.setBackground(buttonColor);
        Screen.changeLang.setForeground(textColor);
        Screen.changeTheme.setBackground(buttonColor);
        Screen.changeTheme.setForeground(textColor);
        Screen.resetData.setBackground(buttonColor);
        Screen.resetData.setForeground(textColor);
    }

    @Override
    public void back()
    {
        Screen.back.setBackground(buttonColor);
        Screen.back.setForeground(textColor);
    }
}