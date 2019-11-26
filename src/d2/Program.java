package d2;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Program {

    private static ItemContentHandler ich = new ItemContentHandler();

    public static void main(String[] args){

        try {
            URL link = new URL("http://www.tagesschau.de/xml/rss2");
            URLConnection conn = link.openConnection();
            InputSource is = new InputSource(conn.getInputStream());
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            xmlreader.setContentHandler(ich);
            xmlreader.parse(is);
            for(Item i : ich.getNews()){
                i.calculateRepresentaion();
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }


    }
}
