package communication;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkOpener
{

    private URI uri;
    public LinkOpener(String link)
    {
        try {uri = new URI(link);}
        catch (URISyntaxException e){e.printStackTrace();}
        open();
    }

    private void open()
    {
        try
        {
            if (Desktop.isDesktopSupported())
            {
                Desktop desktop = Desktop.getDesktop();

                if (desktop.isSupported(Desktop.Action.BROWSE)) desktop.browse(uri);
            }
        }catch (Exception e){e.printStackTrace();}
    }

}