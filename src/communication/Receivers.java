package communication;

import database.Clients;

import javax.swing.*;
import java.util.ArrayList;

public class Receivers
{
    private ArrayList<String> receivers;

    public Receivers(JComboBox<String> receiverList, JComboBox<String> senderList, Clients clients)
    {
        receivers = new ArrayList<>();

        int index = receiverList.getSelectedIndex();

        String sender = senderList.getSelectedItem().toString();
        Senders temp = new Senders(sender, clients);

        if (index == 0)
        {
            for (String r: clients.getClientEmails())
            {
                if (!temp.findMail().equals(r)) receivers.add(r);
            }
        }
        else if (index == 1 || index == 2)
        {
            for (int i = 0; i < clients.getClientPriorities().size(); i++)
            {
                if (clients.getClientPriorities().get(i).equals(Integer.toString(index)))
                {
                    receivers.add(clients.getClientEmails().get(i));
                }
            }
        }
        else receivers.add(new Senders(receiverList.getSelectedItem().toString(), clients).findMail());
    }

    public ArrayList<String> getReceivers() {return receivers;}
}
