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

public class MusicSuggester
{

    private List<String> tracks,artists,albums;

    public MusicSuggester()
    {
        tracks = new ArrayList<>();
        artists = new ArrayList<>();
        albums = new ArrayList<>();

        fill();
    }

    private void fill()
    {
        String dir = "data";
        String file = "suggest.csv";

        Path dirPath = Paths.get(dir);
        Path filePath = dirPath.resolve(file);

        try
        {
            CSVParser parser = CSVParser.parse(filePath, Charset.defaultCharset(), CSVFormat.DEFAULT.withHeader("track","artist","album"));
            Stream<CSVRecord> stream = StreamSupport.stream(parser.spliterator(), false);
            List<Map<String, String>> temp = stream.skip(1).map(record -> record.toMap()).collect(Collectors.toList());

            tracks = temp.stream().map(column -> column.get("track")).collect(Collectors.toList());
            artists = temp.stream().map(column -> column.get("artist")).collect(Collectors.toList());
            albums = temp.stream().map(column -> column.get("album")).collect(Collectors.toList());
        }
        catch (Exception e){e.printStackTrace();}
    }

    public List<String> getTracks() {return tracks;}
    public List<String> getArtists() {return artists;}
    public List<String> getAlbums() {return albums;}

}
