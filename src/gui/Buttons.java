package gui;

import communication.Admins;
import communication.Email;
import communication.Receivers;
import communication.Senders;
import database.Clients;
import database.SaveTypes;
import database.Saves;
import exceptions.UserExceptions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

public class Buttons implements IFrames
{

    private final Clients clients;
    private JFrame frame;
    private boolean wasInformed;

    protected Buttons(Clients clients, JFrame frame)
    {
        this.clients = clients;
        this.frame = frame;

        wasInformed = false;

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
                new AppText(clients, true).reload(Frames.SEND_FRAME);
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
                new AppText(clients, true).reload(Frames.USER_FRAME);
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

                Screen.mailText.setText(null);
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

        Screen.singleMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (Screen.userList.getSelectedItem() != null)
                {
                    Screen.specificReceiver.setText(Screen.userList.getSelectedItem().toString());

                    new Visibility(Frames.USER_FRAME, false);
                    new Visibility(Frames.SEND_FRAME, true);
                    Screen.receiverList.setVisible(false);
                    Screen.specificReceiver.setVisible(true);
                    new AppText(clients, true).reload(Frames.SEND_FRAME);
                }
            }
        });

        Screen.removeUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                clients.remove(Screen.userList.getSelectedItem().toString());
                int delete = Screen.userList.getSelectedIndex();
                Screen.userList.setSelectedItem(null);
                Screen.userList.removeItemAt(delete);
            }
        });

        Screen.addUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (!wasInformed)
                {
                    if (new UserExceptions(Screen.nameSection, Screen.surnameSection, Screen.emailSection, Screen.exceptionSection, Screen.priorityList, clients).isValid())
                    {
                        if (Screen.priorityList.getSelectedIndex() != 0)
                        {
                            clients.add(Screen.nameSection.getText(), Screen.surnameSection.getText(), Screen.emailSection.getText(), Integer.toString(Screen.priorityList.getSelectedIndex()));

                            Screen.nameSection.setText(null);
                            Screen.surnameSection.setText(null);
                            Screen.emailSection.setText(null);
                            Screen.exceptionSection.setText(null);
                            Screen.priorityList.setSelectedItem(null);
                            Screen.userList.addItem(clients.getClientNames().get(clients.getClientNames().size()-1) + " " + clients.getClientSurnames().get(clients.getClientSurnames().size()-1));
                        }
                        else
                        {
                            new Admins().askPassword(Screen.exceptionSection);
                            wasInformed = true;
                        }
                    }
                }

                else
                {
                    String password = new Admins().getPassword(Screen.exceptionSection);
                    clients.add(Screen.nameSection.getText(), Screen.surnameSection.getText(), Screen.emailSection.getText(), Integer.toString(Screen.priorityList.getSelectedIndex()), password);
                    wasInformed = false;

                    Screen.nameSection.setText(null);
                    Screen.surnameSection.setText(null);
                    Screen.emailSection.setText(null);
                    Screen.exceptionSection.setText(null);
                    Screen.priorityList.setSelectedItem(null);
                    Screen.userList.addItem(clients.getClientNames().get(clients.getClientNames().size()-1) + " " + clients.getClientSurnames().get(clients.getClientSurnames().size()-1));
                }

            }
        });

    }

    @Override
    public void terminalFrame()
    {

    }

    @Override
    public void settingsFrame()
    {
        Screen.changeLang.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                if (Screen.langList.getSelectedItem() != null)
                {
                    Saves newSave = new Saves(Screen.langList.getSelectedIndex());
                    new Saves(SaveTypes.LANG, newSave.getRequested());

                    Screen.langList.removeAllItems();
                    Screen.priorityList.removeAllItems();
                    Screen.userList.removeAllItems();
                    Screen.senderList.removeAllItems();
                    Screen.receiverList.removeAllItems();

                    new AppText(clients);
                }
            }
        });

        Screen.changeTheme.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                String theme = null;

                if (Screen.changeTheme.getBackground() == Color.RED) theme = "light";
                else theme = "dark";

                new Saves(SaveTypes.THEME, theme);
                new Theme(frame);
            }
        });

        Screen.resetData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                new Saves(true);

                Screen.langList.removeAllItems();
                Screen.priorityList.removeAllItems();
                Screen.userList.removeAllItems();
                Screen.senderList.removeAllItems();
                Screen.receiverList.removeAllItems();

                new AppText(clients);
                new Theme(frame);
            }
        });
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

                else if (Screen.specificReceiver.isVisible())
                {
                    new Visibility(Frames.SEND_FRAME, false);
                    new Visibility(Frames.USER_FRAME, true);
                    Screen.specificReceiver.setText(null);
                    new AppText(clients, true).reload(Frames.USER_FRAME);
                }

            }
        });
    }

}
