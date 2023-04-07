package database;

import java.util.ArrayList;

public class Saves extends Communicator
{
    private ArrayList<String> data, script;
    private String requested;

    public Saves(SaveTypes type)
    {
        super("data/saved.txt");

        script = new ArrayList<>();
        this.data = read();

        fill(type);
    }

    public Saves(SaveTypes type, String info)
    {
        super("data/saved.txt");

        change(type, info);
    }

    public Saves(int id)
    {
        super("data/lang/codes.txt");

        requested = read().get(id);
    }

    public Saves()
    {
        super("data/lang/" + new Language().getLanguage() + ".txt");
        script = read();
    }
    public Saves(boolean isReset)
    {
        super("data/saved.txt");

        this.data = read();

        if (isReset)
        {
            getDefault();
            change(SaveTypes.LANG, data.get(0));
            change(SaveTypes.VER, data.get(1));
            change(SaveTypes.CREATOR, data.get(2));
            change(SaveTypes.THEME, data.get(3));
        }
    }


    public String getRequested() {return requested;}
    public ArrayList<String> getScript() {return script;}

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

    private void change(SaveTypes type, String info)
    {
        switch (type)
        {
            case LANG: change(info, 0); break;
            case VER: change(info, 1); break;
            case CREATOR: change(info, 2); break;
            case THEME: change(info, 3); break;
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