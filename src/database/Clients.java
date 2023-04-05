package database;

import communication.Admins;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Clients
{

    private List<String> clientIDs, clientNames, clientSurnames, clientEmails, clientPriorities;

    public Clients()
    {
        call();
    }

    public List<String> getClientIDs() {return clientIDs;}
    public List<String> getClientNames() {return clientNames;}
    public List<String> getClientSurnames() {return clientSurnames;}
    public List<String> getClientEmails() {return clientEmails;}
    public List<String> getClientPriorities() {return clientPriorities;}

    private void call()
    {
        String dir = "data";
        String file = "clients.csv";

        Path dirPath = Paths.get(dir);
        Path filePath = dirPath.resolve(file);

        try
        {
            CSVParser parser = CSVParser.parse(filePath, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader("id", "name", "surname", "email", "priority"));
            Stream<CSVRecord> stream = StreamSupport.stream(parser.spliterator(), false);
            List<Map<String, String>> temp = stream.skip(1).map(record -> record.toMap()).collect(Collectors.toList());

            clientIDs = temp.stream().map(column -> column.get("id")).collect(Collectors.toList());
            clientNames = temp.stream().map(column -> column.get("name")).collect(Collectors.toList());
            clientSurnames = temp.stream().map(column -> column.get("surname")).collect(Collectors.toList());
            clientEmails = temp.stream().map(column -> column.get("email")).collect(Collectors.toList());
            clientPriorities = temp.stream().map(column -> column.get("priority")).collect(Collectors.toList());
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void add(String name, String surname, String email, String priority)
    {
        clientNames.add(name);
        clientSurnames.add(surname);
        clientEmails.add(email);
        clientPriorities.add(priority);

        int id = Integer.parseInt(clientIDs.get(clientIDs.size() - 1)) + 1;
        clientIDs.add(Integer.toString(id));

        rewrite();
    }

    public void add(String name, String surname, String email, String priority, String password)
    {
        clientNames.add(name);
        clientSurnames.add(surname);
        clientEmails.add(email);
        clientPriorities.add(priority);

        int id = Integer.parseInt(clientIDs.get(clientIDs.size() - 1)) + 1;
        clientIDs.add(Integer.toString(id));

        rewrite();

        new Admins().addAdminPassword(clientIDs.get(clientIDs.size()-1), password);
    }


    public void remove(String nameSurname)
    {
        Integer id = null;
        Integer deletedID = null;

        for (int i = 0; i < clientNames.size(); i++)
        {
            String temp = clientNames.get(i) + " " + clientSurnames.get(i);

            if (nameSurname.equals(temp))
            {
                id = i;
                deletedID = Integer.parseInt(clientIDs.get(i));
                break;
            }
        }

        clientIDs.remove((int) id);
        clientNames.remove((int) id);
        clientSurnames.remove((int) id);
        clientEmails.remove((int) id);
        clientPriorities.remove((int) id);

        for (int i = id; i < clientIDs.size(); i++)
        {
            clientIDs.set(i, deletedID.toString());
            deletedID++;
        }

        rewrite();

    }

    private void rewrite()
    {
        try
        {
            File csvFile = new File("data/clients.csv");
            FileWriter writer = new FileWriter(csvFile);
            CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);

            printer.printRecord("id", "name", "surname", "email", "priority");

            for (int i = 0; i < clientNames.size(); i++)
            {
                printer.printRecord(clientIDs.get(i), clientNames.get(i), clientSurnames.get(i), clientEmails.get(i), clientPriorities.get(i));
            }

            printer.close();

        }catch (IOException e){e.printStackTrace();}
    }

}
