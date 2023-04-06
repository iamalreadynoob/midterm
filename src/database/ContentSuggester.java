package database;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ContentSuggester
{
    private List<String> title,synopsis,genre,aired,episodes,members,score,link;

    public ContentSuggester()
    {
        title = new ArrayList<>();
        synopsis = new ArrayList<>();
        genre = new ArrayList<>();
        aired = new ArrayList<>();
        episodes = new ArrayList<>();
        members = new ArrayList<>();
        score = new ArrayList<>();
        link = new ArrayList<>();

        fill();
    }

    private void fill()
    {
        String dir = "data";
        String file = "???db.csv";

        Path dirPath = Paths.get(dir);
        Path filePath = dirPath.resolve(file);

        try
        {
            CSVParser parser = CSVParser.parse(filePath, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader("title","synopsis","genre","aired","episodes","members","score","link"));
            Stream<CSVRecord> stream = StreamSupport.stream(parser.spliterator(), false);
            List<Map<String, String>> temp = stream.skip(1).map(record -> record.toMap()).collect(Collectors.toList());

            title = temp.stream().map(column -> column.get("title")).collect(Collectors.toList());
            synopsis = temp.stream().map(column -> column.get("synopsis")).collect(Collectors.toList());
            genre = temp.stream().map(column -> column.get("genre")).collect(Collectors.toList());
            aired = temp.stream().map(column -> column.get("aired")).collect(Collectors.toList());
            episodes = temp.stream().map(column -> column.get("episodes")).collect(Collectors.toList());
            members = temp.stream().map(column -> column.get("members")).collect(Collectors.toList());
            score = temp.stream().map(column -> column.get("score")).collect(Collectors.toList());
            link = temp.stream().map(column -> column.get("link")).collect(Collectors.toList());
        }
        catch (Exception e){e.printStackTrace();}
    }

    public List<String> getAired() {return aired;}
    public List<String> getEpisodes() {return episodes;}
    public List<String> getGenre() {return genre;}
    public List<String> getLink() {return link;}
    public List<String> getMembers() {return members;}
    public List<String> getScore() {return score;}
    public List<String> getSynopsis() {return synopsis;}
    public List<String> getTitle() {return title;}
}
