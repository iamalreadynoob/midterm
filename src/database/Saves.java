package database;

import java.util.ArrayList;

public class Saves extends Communicator
{
    private ArrayList<String> data;
    private String requested;

    public Saves(SaveTypes type)
    {
        super("data/saved.txt");

        this.data = read();

        fill(type);
    }

    public String getRequested() {return requested;}

    private void fill(SaveTypes type)
    {
        switch (type)
        {
            case LANG: requested = data.get(0); break;
            case VER: requested = data.get(1); break;
            case CREATOR: requested = data.get(2); break;
            case THEME: requested = data.get(3); break;
        }
    }

    private ArrayList<String> getDefault()
    {
        while (data.size() >= 1) data.remove(0);

        data.add("eng");
        data.add("v1.0");
        data.add("Sadık Efe Kartav - 22120205381");
        data.add("dark");

        return data;
    }

}
