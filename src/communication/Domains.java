package communication;

import database.Communicator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Domains
{

    private ArrayList<String> publicDomains;
    public Domains()
    {
        publicDomains = new ArrayList<>();

        listPublicDomains();

        //System.out.println(publicDomains.get(14));
    }

    public boolean isIncluded(String mail)
    {
        boolean is = false;

        for (String domain: publicDomains)
        {
            if (mail.endsWith(domain))
            {
                is = true;
                break;
            }
        }

        return is;
    }

    private void listPublicDomains()
    {
        File domainFile = new File("data/domains.txt");
        try
        {
            FileReader reader = new FileReader(domainFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) publicDomains.add(line);
        }catch (IOException e){e.printStackTrace();}
    }


}
