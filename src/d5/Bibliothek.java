package d5;

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
        String suchen = "Optimierung_von_Kleinheizungsanlagen";
        try{
            URL link = new URL("https://de.wikibooks.org/wiki/Spezial:Export/"+suchen);
            URLConnection conn = link.openConnection();
            InputSource is = new InputSource(conn.getInputStream());
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            xmlreader.setContentHandler(wch);
            xmlreader.parse(is);
            if(zk.addMedium(wch.getCurrentMedium())){
                ArrayList<Medium> tmp = zk.findMedium(suchen.replace("_"," "));
                System.out.println("Suche nach: "+suchen.replace("_", " "));
                for(Medium m:tmp){
                    System.out.println(m.calculateRepresentation());
                }
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
    }
}
