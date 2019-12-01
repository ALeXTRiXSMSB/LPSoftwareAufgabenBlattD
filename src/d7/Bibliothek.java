package d7;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Bibliothek {

    /**
     * Programm Einstiegspunkt
     * @param args
     */
    public static void main(String[] args){
        Zettelkasten zk = new Zettelkasten();
        WikibooksContentHandler wch = new WikibooksContentHandler();
        String suchen = "Java_Standard";
        try{
            URL link = new URL("https://de.wikibooks.org/wiki/Spezial:Export/"+suchen);
            URLConnection conn = link.openConnection();
            InputSource is = new InputSource(conn.getInputStream());
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            xmlreader.setContentHandler(wch);
            xmlreader.parse(is);

            URL link2 = new URL("https://de.wikibooks.org/w/api.php?action=parse&format=xml&prop=sections&page="+suchen);
            URLConnection conn2 = link2.openConnection();
            InputSource is2 = new InputSource(conn2.getInputStream());
            XMLReader xmlreader2 = XMLReaderFactory.createXMLReader();
            xmlreader2.setContentHandler(wch);
            xmlreader2.parse(is2);

            URL link3 = new URL("https://de.wikibooks.org/w/api.php?action=parse&format=xml&prop=links&page="+suchen);
            URLConnection conn3 = link3.openConnection();
            InputSource is3 = new InputSource(conn3.getInputStream());
            XMLReader xmlreader3 = XMLReaderFactory.createXMLReader();
            xmlreader3.setContentHandler(wch);
            xmlreader3.parse(is3);

            WikiBuch wb = wch.getCurrentBuch();
            if(wb != null){
                System.out.println("Suche nach: "+suchen.replace("_", " "));
                wb.print();
            }else{
                System.out.println("Das Buch wurde leider nicht gefunden");
            }
        }catch (MalformedURLException e) {
            System.out.println("URL ist ungültig");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        zk.addMedium(new Buch("test",1,"test","1234","test"));
        zk.addMedium(new Buch("test",1,"test","1234","test"));
        zk.addMedium(new Buch("test",1,"test","1234","test"));
        XMLPersistency test = new XMLPersistency();
        test.save(zk,"bonus.xml");
    }
}
