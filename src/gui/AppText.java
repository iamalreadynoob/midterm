package gui;

import database.Clients;
import database.Communicator;
import database.Language;

import java.util.ArrayList;

public class AppText extends Communicator implements IFrames
{
    private ArrayList<String> script;
    private Clients clients;
    protected AppText(Clients clients)
    {
        super("data/lang/" + new Language().getLanguage() + ".txt");
        this.clients = clients;

        script = read();

        mainFrame();
        sendFrame();
        userFrame();
        terminalFrame();
        settingsFrame();
        back();
    }

    public AppText(Clients clients, boolean onlyReload)
    {
        super("data/lang/" + new Language().getLanguage() + ".txt");

        if (onlyReload)
        {
            script = read();
            this.clients = clients;
        }
    }

    @Override
    public void mainFrame()
    {
        Screen.goSend.setText(script.get(0));
        Screen.goUser.setText(script.get(1));
        Screen.goTerminal.setText(script.get(2));
        Screen.goSettings.setText(script.get(3));
    }

    @Override
    public void sendFrame()
    {
        Screen.sendHeader.setText(script.get(0).toUpperCase());
        Screen.from.setText(script.get(24).toUpperCase() + ":");
        Screen.to.setText(script.get(25).toUpperCase() + ":");
        Screen.sendMail.setText(script.get(0));

        Screen.receiverList.addItem(script.get(26));
        Screen.receiverList.addItem(script.get(20));
        Screen.receiverList.addItem(script.get(21));

        for (int i = 0; i < clients.getClientNames().size(); i++)
        {
            if (clients.getClientPriorities().get(i).equals("0")) Screen.senderList.addItem(clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i));

            Screen.receiverList.addItem(clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i));
        }
    }

    @Override
    public void userFrame()
    {
        Screen.userHeader.setText(script.get(1).toUpperCase());
        Screen.nameSection.setText(script.get(16));
        Screen.surnameSection.setText(script.get(17));
        Screen.emailSection.setText(script.get(18));
        Screen.priorityList.addItem(script.get(19));
        Screen.priorityList.addItem(script.get(20));
        Screen.priorityList.addItem(script.get(21));
        Screen.addUser.setText(script.get(22));
        Screen.singleMail.setText(script.get(0));
        Screen.removeUser.setText(script.get(23));

        for (int i = 0; i < clients.getClientNames().size(); i++)
        {
            Screen.userList.addItem(clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i));
        }
    }

    @Override
    public void terminalFrame()
    {
        Screen.terminalHeader.setText(script.get(2).toUpperCase());
    }

    @Override
    public void settingsFrame()
    {
        Screen.settingsHeader.setText(script.get(3).toUpperCase());
        for (int i = 4; i < 10; i++) Screen.langList.addItem(script.get(i));
        Screen.changeLang.setText(script.get(10));
        Screen.changeTheme.setText(script.get(11));
        Screen.resetData.setText(script.get(12));

        ArrayList<String> details = credits();
        Screen.infoRow.setText(script.get(14) + ": " + details.get(0) + "\t" + script.get(15) + " " + details.get(1));
    }

    @Override
    public void back()
    {
        Screen.back.setText(script.get(13));
    }

    public void reload(Frames frame)
    {
        switch (frame)
        {
            case USER_FRAME:
                Screen.userList.removeAllItems();
                for (int i = 0; i < clients.getClientNames().size(); i++)
                {
                    Screen.userList.addItem(clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i));
                }
                break;

            case SEND_FRAME:
                Screen.senderList.removeAllItems();
                Screen.receiverList.removeAllItems();

                Screen.receiverList.addItem(script.get(26));
                Screen.receiverList.addItem(script.get(20));
                Screen.receiverList.addItem(script.get(21));

                for (int i = 0; i < clients.getClientNames().size(); i++)
                {
                    if (clients.getClientPriorities().get(i).equals("0")) Screen.senderList.addItem(clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i));

                    Screen.receiverList.addItem(clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i));
                }
                break;

        }
    }
}
