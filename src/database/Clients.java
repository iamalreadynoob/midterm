package database;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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

}
