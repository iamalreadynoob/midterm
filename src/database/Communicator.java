package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Communicator
{
    private String filePath;
    protected Communicator(String filePath)
    {
        this.filePath = filePath;
    }

    protected ArrayList<String> read()
    {
        ArrayList<String> data = new ArrayList<>();

        String rawData = getRawData();

        int loc = 0;

        while (loc < rawData.length())
        {
            if (rawData.charAt(loc) != ',')
            {
                String newData = null;

                while (loc < rawData.length() && rawData.charAt(loc) != ',')
                {

                    if (newData == null) newData = Character.toString(rawData.charAt(loc));
                    else newData += Character.toString(rawData.charAt(loc));

                    loc++;
                }

                data.add(newData);
            }

            loc++;
        }

        return data;
    }

    public ArrayList<String> credits()
    {
        String temp = filePath;
        filePath = "data/saved.txt";

        ArrayList<String> pool = read();

        ArrayList<String> requested = new ArrayList<>();
        requested.add(pool.get(1));
        requested.add(pool.get(2));

        filePath = temp;

        return requested;
    }

    public String getRawData()
    {
        String raw = null;

        try
        {

            File file = new File(filePath);
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                if (raw == null) raw = line;
                else raw += line;
            }

        }
        catch (IOException e) {e.printStackTrace();}

        return raw;
    }


}
