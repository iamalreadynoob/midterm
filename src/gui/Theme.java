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
