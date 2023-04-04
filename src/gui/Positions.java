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
        Screen.sendHeader.setBounds(10, 20, 200, 30);
        Screen.sendHeader.setBackground(null);
        Screen.sendHeader.setEditable(false);
        Screen.sendHeader.setBorder(null);
        Screen.sendHeader.setFont(new Font("arial", Font.BOLD, 20));

        Screen.from.setBounds(10, 100, 100, 30);
        Screen.from.setBackground(null);
        Screen.from.setBorder(null);
        Screen.from.setEditable(false);

        Screen.senderList.setBounds(110, 100, 100, 30);
        Screen.senderList.setBorder(null);

        Screen.to.setBounds(220, 100, 100, 30);
        Screen.to.setBackground(null);
        Screen.to.setBorder(null);
        Screen.to.setEditable(false);

        Screen.specificReceiver.setBounds(320, 100, 200, 30);
        Screen.specificReceiver.setBackground(null);
        Screen.specificReceiver.setBorder(null);
        Screen.specificReceiver.setEditable(false);

        Screen.receiverList.setBounds(320, 100, 200, 30);
        Screen.receiverList.setBorder(null);

        Screen.mailText.setBounds(10, 150, 400, 200);
        Screen.mailText.setBorder(null);

        Screen.sendMail.setBounds(450, 320, 100, 30);
        Screen.sendMail.setBorder(null);
    }

    @Override
    public void userFrame()
    {
        Screen.userHeader.setBounds(10, 20, 200, 30);
        Screen.userHeader.setBackground(null);
        Screen.userHeader.setEditable(false);
        Screen.userHeader.setBorder(null);
        Screen.userHeader.setFont(new Font("arial", Font.BOLD, 20));

        Screen.nameSection.setBounds(10, 100, 100, 30);
        Screen.nameSection.setBorder(null);

        Screen.surnameSection.setBounds(140, 100, 100, 30);
        Screen.surnameSection.setBorder(null);

        Screen.emailSection.setBounds(270, 100, 100, 30);
        Screen.emailSection.setBorder(null);

        Screen.priorityList.setBounds(400, 100, 100, 30);
        Screen.priorityList.setBorder(null);
        Screen.priorityList.setSelectedItem(null);

        Screen.addUser.setBounds(530, 100, 60, 30);
        Screen.addUser.setBorder(null);

        Screen.exceptionSection.setBounds(10, 150, 300, 30);
        Screen.exceptionSection.setBackground(null);
        Screen.exceptionSection.setBorder(null);
        Screen.exceptionSection.setEditable(false);

        Screen.userList.setBounds(10, 220, 200, 30);
        Screen.userList.setBorder(null);
        Screen.userList.setSelectedItem(null);

        Screen.singleMail.setBounds(240, 220, 60, 30);
        Screen.singleMail.setBorder(null);

        Screen.removeUser.setBounds(330, 220, 60, 30);
        Screen.removeUser.setBorder(null);
    }

    @Override
    public void terminalFrame()
    {
        Screen.terminalHeader.setBounds(10, 20, 200, 30);
        Screen.terminalHeader.setBackground(null);
        Screen.terminalHeader.setEditable(false);
        Screen.terminalHeader.setBorder(null);
        Screen.terminalHeader.setFont(new Font("arial", Font.BOLD, 20));

        Screen.cmdArea.setBounds(10, 100, 490, 250);
        Screen.cmdArea.setBorder(null);

        Screen.terminalHelp.setBounds(530, 300, 50, 50);
        Screen.terminalHelp.setBorder(null);
        Screen.terminalHelp.setText("?");
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
