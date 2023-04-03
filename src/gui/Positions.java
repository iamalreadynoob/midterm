package gui;

import javax.swing.*;
import java.awt.*;

public class Positions implements IFrames
{

    protected Positions()
    {
        new Visibility(Frames.MAIN_FRAME, true);

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
        Screen.appName.setBounds(200, 40, 200, 30);
        Screen.appName.setText("communicator".toUpperCase());
        Screen.appName.setHorizontalAlignment(SwingConstants.CENTER);
        Screen.appName.setBorder(null);
        Screen.appName.setBackground(null);
        Screen.appName.setFont(new Font("arial", Font.BOLD, 20));
        Screen.appName.setEditable(false);

        Screen.goSend.setBounds(200, 120, 200, 30);
        Screen.goSend.setBorder(null);

        Screen.goUser.setBounds(200, 160, 200, 30);
        Screen.goUser.setBorder(null);

        Screen.goTerminal.setBounds(200, 200, 200, 30);
        Screen.goTerminal.setBorder(null);

        Screen.goSettings.setBounds(200, 240, 200, 30);
        Screen.goSettings.setBorder(null);
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
        Screen.settingsHeader.setBounds(10, 20, 200, 30);
        Screen.settingsHeader.setBackground(null);
        Screen.settingsHeader.setEditable(false);
        Screen.settingsHeader.setBorder(null);
        Screen.settingsHeader.setFont(new Font("arial", Font.BOLD, 20));

        Screen.langList.setBounds(10, 100, 200, 30);
        Screen.langList.setBorder(null);
        Screen.langList.setSelectedItem(null);

        Screen.changeLang.setBounds(250, 100, 150, 30);
        Screen.changeLang.setBorder(null);

        Screen.changeTheme.setBounds(10, 150, 250, 30);
        Screen.changeTheme.setBorder(null);

        Screen.resetData.setBounds(10, 230, 150, 30);
        Screen.resetData.setBorder(null);

        Screen.infoRow.setBounds(10, 300, 580, 30);
        Screen.infoRow.setBorder(null);
        Screen.infoRow.setEditable(false);
        Screen.infoRow.setFont(new Font("arial", Font.PLAIN, 15));
        Screen.infoRow.setBackground(null);
    }

    @Override
    public void back()
    {
        Screen.back.setBounds(470, 20, 100, 30);
        Screen.back.setBorder(null);
    }

}
