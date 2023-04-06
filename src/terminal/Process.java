package terminal;

import communication.Email;
import communication.LinkOpener;
import database.Clients;
import database.ContentSuggester;
import database.MusicSuggester;

import javax.swing.*;
import java.io.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class Process
{
    private String command;
    private ArrayList<String> arguments, commandList;
    private JTextArea cmdArea;
    private Clients clients;
    private JFrame frame;
    public Process(JTextArea cmdArea, Clients clients, JFrame frame)
    {
        this.cmdArea = cmdArea;
        this.clients = clients;
        this.frame = frame;

        Parser parser = new Parser(cmdArea.getText());

        command = parser.getCommand();
        arguments = parser.getArguments();
        commandList = new TerminalCommands().getCommands();

        general();
    }

    private void general()
    {
        if (command.equals(commandList.get(0))) {help();}

        else if (command.equals(commandList.get(1))) {clear();}

        else if (command.equals(commandList.get(2))) {send();}

        else if (command.equals(commandList.get(3))) {info();}

        else if (command.equals(commandList.get(4))) {list();}

        else if (command.equals(commandList.get(5))) {export();}

        else if (command.equals(commandList.get(6))) {importFile();}

        else if (command.equals(commandList.get(7))) {close();}

        else if (command.equals(commandList.get(8))) {time();}

        else if (command.equals(commandList.get(9))) {suggest();}

        else if (command.equals(commandList.get(10))) {floppyDisk();}

        else if (command.equals(commandList.get(11))) {questionMark();}

        else if (command.equals(commandList.get(12))) {anime();}

        else if (command.equals(commandList.get(13))) {share();}

        else
        {
            //TODO: exception!!!
        }
    }

    private void clear() {cmdArea.setText(null);}
    private void info()
    {
        Integer id = null;

        for (int i = 0; i < clients.getClientNames().size(); i++)
        {
            if (arguments.get(0).equals(clients.getClientEmails().get(i)))
            {
                id = i;
                break;
            }
        }

        if (id != null)
        {
            String answer = "\nname: " + clients.getClientNames().get(id) + "\nsurname: " + clients.getClientSurnames().get(id) + "\npriority: " + clients.getClientPriorities().get(id);
            cmdArea.setText(cmdArea.getText() + answer);
        }
        else
        {
            //TODO: exception!!!
        }
    }

    private void list()
    {
        String answer = null;

        for (int i = 0; i < clients.getClientPriorities().size(); i++)
        {
            if (arguments.get(0).equals(clients.getClientPriorities().get(i)))
            {
                if (answer == null) answer = "\n" + clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i) + " (" + clients.getClientEmails().get(i) + ")";
                else answer += "\n" + clients.getClientNames().get(i) + " " + clients.getClientSurnames().get(i) + " (" + clients.getClientEmails().get(i) + ")";
            }
        }

        if (answer != null)
        {
            cmdArea.setText(cmdArea.getText() + answer);
        }
        else
        {
            //TODO: exception!!!
        }
    }

    private void close() {frame.dispose();}

    private void time()
    {
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm");
        String answer = localTime.format(formatter);

        cmdArea.setText(cmdArea.getText() + "\n" + answer);
    }

    private void send()
    {
        ArrayList<String> receivers = new ArrayList<>();

        if (arguments.get(1).equals("all"))
        {
            for (String e: clients.getClientEmails())
            {
                if (!e.equals(arguments.get(0))) receivers.add(e);
            }
        }
        else if (arguments.get(1).equals("vip"))
        {
            for (int i = 0; i < clients.getClientPriorities().size(); i++)
            {
                if (clients.getClientPriorities().get(i).equals("1")) receivers.add(clients.getClientEmails().get(i));
            }
        }
        else if (arguments.get(1).equals("member"))
        {
            for (int i = 0; i < clients.getClientPasswords().size(); i++)
            {
                if (clients.getClientPriorities().get(i).equals("2")) receivers.add(clients.getClientEmails().get(i));
            }
        }
        else
        {
            receivers.add(arguments.get(1));
        }

        new Email(arguments.get(0), receivers, arguments.get(2), clients);
    }

    private void export()
    {
        try
        {
            File exported = new File("clients.txt");
            FileWriter writer = new FileWriter(exported);

            writer.write("ID,NAME,SURNAME,EMAIL,PRIORITY,PASSWORD\n");

            for (int i = 0; i < clients.getClientIDs().size(); i++)
            {
                writer.write(clients.getClientIDs().get(i)+","+clients.getClientNames().get(i)+","+clients.getClientSurnames().get(i)+","+clients.getClientEmails().get(i)+","+clients.getClientPriorities().get(i)+","+clients.getClientPasswords().get(i)+"\n");
            }

            writer.close();
            cmdArea.setText(cmdArea.getText() + "\nexit code 0");
        }catch (IOException e){e.printStackTrace();}
    }

    private void importFile()
    {
        ArrayList<String> lines = new ArrayList<>();

        try
        {
            File imported = new File(arguments.get(0));
            FileReader fileReader = new FileReader(imported);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) lines.add(line);
        }
        catch (IOException e){e.printStackTrace();}

        for (int i = 0; i < lines.size(); i++)
        {
            ArrayList<String> temp = new ArrayList<>();
            int loc = 0;

            while (loc < lines.get(i).length())
            {
                if (lines.get(i).charAt(loc) != ' ')
                {
                    String item = null;

                    while (loc < lines.get(i).length() && lines.get(i).charAt(loc) != ',')
                    {

                        if (item == null) item = Character.toString(lines.get(i).charAt(loc));
                        else item += Character.toString(lines.get(i).charAt(loc));

                        loc++;
                    }

                    temp.add(item);
                }

                loc++;
            }

            clients.add(temp.get(0), temp.get(1), temp.get(2), temp.get(3), temp.get(4));
        }

        cmdArea.setText(cmdArea.getText() + "\nexit code 0");
    }

    private void suggest()
    {
        MusicSuggester suggestions = new MusicSuggester();
        int id = new Random().nextInt(suggestions.getTracks().size());

        cmdArea.setText(cmdArea.getText() + "\ni think you should listen to " + suggestions.getTracks().get(id) + " from " + suggestions.getArtists().get(id) + "! (in " + suggestions.getAlbums().get(id) + ")");
    }

    private void questionMark()
    {
        cmdArea.setText(cmdArea.getText() + "\nthere is the github page of the creator of this project:\nhttps://github.com/iamalreadynoob");
        new LinkOpener("https://github.com/iamalreadynoob");
    }

    private void anime()
    {
        ContentSuggester content = new ContentSuggester();

        int id = new Random().nextInt(content.getTitle().size());

        String answer = "You should watch this:\ntitle: " + content.getTitle().get(id) + "\nsynopsis: " + content.getSynopsis().get(id) + "\ngenre: " + content.getGenre().get(id) + "\naired: " + content.getAired().get(id) + "\nepisodes: " + content.getEpisodes().get(id) + "\nmembers: " + content.getMembers().get(id) + "\nscore in MyAnimeList: " + content.getScore().get(id) + "\nlink: " + content.getLink().get(id);

        cmdArea.setText(cmdArea.getText() + "\n" + answer);
    }

    private void floppyDisk()
    {
        final long floppyDiskSize = 1258291;

        File file = new File("data/clients.csv");
        long size = file.length();

        String answer = null;

        if (size < floppyDiskSize) {answer = "you still have free " + Long.toString(floppyDiskSize - size) + " bytes to fill a floppy disk!";}
        else if (size == floppyDiskSize) {answer = "you have a data that can fill an exact floppy disk!";}
        else {answer = "you have a data that can fill " + Long.toString(size / floppyDiskSize) + " floppy disks!";}

        cmdArea.setText(cmdArea.getText() + "\n" + answer);
    }

    private void share()
    {
        String text = null;

        if (arguments.get(0).equals("song"))
        {
            MusicSuggester suggestions = new MusicSuggester();
            int id = new Random().nextInt(suggestions.getTracks().size());

            text = "I think you should listen to " + suggestions.getTracks().get(id) + " from " + suggestions.getArtists().get(id) + "! (in " + suggestions.getAlbums().get(id) + ")";
        }
        else if (arguments.get(0).equals("anime"))
        {
            ContentSuggester content = new ContentSuggester();
            int id = new Random().nextInt(content.getTitle().size());
            text = "You should watch this:\ntitle: " + content.getTitle().get(id) + "\nsynopsis: " + content.getSynopsis().get(id) + "\ngenre: " + content.getGenre().get(id) + "\naired: " + content.getAired().get(id) + "\nepisodes: " + content.getEpisodes().get(id) + "\nmembers: " + content.getMembers().get(id) + "\nscore in MyAnimeList: " + content.getScore().get(id) + "\nlink: " + content.getLink().get(id);
        }
        else
        {
            //TODO: exception
        }

        if (text != null)
        {
            String sender = arguments.get(1);
            ArrayList<String> receivers = new ArrayList<>();

            if (arguments.get(2).equals("all"))
            {
                for (String e: clients.getClientEmails())
                {
                    if (!e.equals(arguments.get(1))) receivers.add(e);
                }
            }
            else if (arguments.get(2).equals("vip"))
            {
                for (int i = 0; i < clients.getClientPriorities().size(); i++)
                {
                    if (clients.getClientPriorities().get(i).equals("1")) receivers.add(clients.getClientEmails().get(i));
                }
            }
            else if (arguments.get(2).equals("member"))
            {
                for (int i = 0; i < clients.getClientPasswords().size(); i++)
                {
                    if (clients.getClientPriorities().get(i).equals("2")) receivers.add(clients.getClientEmails().get(i));
                }
            }
            else {receivers.add(arguments.get(2));}

            new Email(sender, receivers, text, clients);
        }
    }

    private void help()
    {
        new LinkOpener("https://allinoneforsmthng.blogspot.com/2023/04/terminal-commands.html");
    }
}
