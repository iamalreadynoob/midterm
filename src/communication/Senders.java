package communication;

import database.Clients;

public class Senders
{
    String sender;
    Clients clients;

    public Senders(String sender, Clients clients)
    {
        this.sender = sender;
        this.clients = clients;
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