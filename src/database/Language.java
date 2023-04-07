package database;

public class Language extends Communicator
{
    private String language;
    public Language()
    {
        super("data/saved.txt");
        language = read().get(0);
    }

    public String getLanguage() {return language;}
}