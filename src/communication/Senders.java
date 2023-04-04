package communication;

import database.Clients;

import javax.swing.*;

public class Senders
{
    String sender;
    Clients clients;

    public Senders(String sender, Clients clients)
    {
        this.sender = sender;
        this.clients = clients;
    }

    public Integer findID()
    {
        Integer id = null;

        for (int i = 0; i < clients.getClientEmails().size(); i++)
        {
            String tempName = clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i);

            if (tempName.equals(sender))
            {
                id = Integer.parseInt(clients.getClientIDs().get(i));
                break;
            }
        }

        return id;
    }

    public String findMail()
    {
        String mail = null;
        String name = sender;

        for (int i = 0; i < clients.getClientNames().size(); i++)
        {
            String temp = clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i);

            if (temp.equals(name))
            {
                mail = clients.getClientEmails().get(i);
                break;
            }
        }

        return mail;
    }

}
