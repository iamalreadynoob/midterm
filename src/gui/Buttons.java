package gui;

import communication.Email;
import communication.Receivers;
import communication.Senders;
import database.Clients;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class Buttons implements IFrames
{

    private final Clients clients;

    protected Buttons(Clients clients)
    {
        this.clients = clients;

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
        Screen.goSend.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility(Frames.MAIN_FRAME, false);
                new Visibility(Frames.SEND_FRAME, true);
                new Visibility(Frames.BACK, true);
            }

        });

        Screen.goUser.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility(Frames.MAIN_FRAME, false);
                new Visibility(Frames.USER_FRAME, true);
                new Visibility(Frames.BACK, true);
            }

        });

        Screen.goTerminal.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility(Frames.MAIN_FRAME, false);
                new Visibility(Frames.TERMINAL_FRAME, true);
                new Visibility(Frames.BACK, true);
            }

        });

        Screen.goSettings.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Visibility(Frames.MAIN_FRAME, false);
                new Visibility(Frames.SETTINGS_FRAME, true);
                new Visibility(Frames.BACK, true);


            }

        });
    }

    @Override
    public void sendFrame()
    {
        Screen.sendMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Senders sender = new Senders(Screen.senderList.getSelectedItem().toString(), clients);

                ArrayList<String> receivers = new ArrayList<>();
                if (Screen.specificReceiver.isVisible()) receivers.add(new Senders(Screen.specificReceiver.getText(), clients).findMail());
                else receivers = new Receivers(Screen.receiverList, Screen.senderList, clients).getReceivers();

                new Email(sender.findMail(), sender.findID().toString(), receivers, Screen.mailText.getText());
            }
        });
    }

    @Override
    public void userFrame()
    {
        Screen.nameSection.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent)
            {
                Screen.nameSection.setText(null);
            }
            @Override
            public void focusLost(FocusEvent focusEvent) {}
        });

        Screen.surnameSection.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                Screen.surnameSection.setText(null);
            }
            @Override
            public void focusLost(FocusEvent focusEvent) {}
        });

        Screen.emailSection.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                Screen.emailSection.setText(null);
            }
            @Override
            public void focusLost(FocusEvent focusEvent) {}
        });

    }

    @Override
    public void terminalFrame()
    {

    }

    @Override
    public void settingsFrame()
    {

    }

    @Override
    public void back()
    {
        Screen.back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {

                if (Screen.settingsHeader.isVisible())
                {
                    new Visibility(Frames.SETTINGS_FRAME, false);
                    new Visibility(Frames.BACK, false);
                    new Visibility(Frames.MAIN_FRAME, true);
                }

                else if (Screen.userHeader.isVisible())
                {
                    new Visibility(Frames.USER_FRAME, false);
                    new Visibility(Frames.BACK, false);
                    new Visibility(Frames.MAIN_FRAME, true);
                }

                else if (Screen.terminalHeader.isVisible())
                {
                    new Visibility(Frames.TERMINAL_FRAME, false);
                    new Visibility(Frames.BACK, false);
                    new Visibility(Frames.MAIN_FRAME, true);
                }

                else if (Screen.receiverList.isVisible())
                {
                    new Visibility(Frames.SEND_FRAME, false);
                    new Visibility(Frames.BACK, false);
                    new Visibility(Frames.MAIN_FRAME, true);
                }

            }
        });
    }

}
