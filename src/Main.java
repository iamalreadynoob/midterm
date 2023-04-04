import database.Clients;
import gui.Screen;

public class Main
{

    public static void main(String[] args)
    {
        Clients clients = new Clients();

        new Screen(clients);
    }
}