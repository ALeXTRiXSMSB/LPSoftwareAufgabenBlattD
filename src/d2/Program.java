package d2;
/**
 * @author Alexander Karg
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Program {

    public static void main(String[] args){
        try{
            //abholen des rss feed
            URL link = new URL("http://www.tagesschau.de/xml/rss2");
            //Zeilen weise einlesen
            BufferedReader br = new BufferedReader(new InputStreamReader(link.openStream(),StandardCharsets.UTF_8));
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
            //Byte weise lesen
            /**
             * URLConnection conn = link.openConnection();
             * InputStream is = conn.getInputStream();
             * int i = 0;
            while((i = is.read()) != -1){
                System.out.print((char)i);
            }
             **/
        } catch(IOException e){

        }
    }
}
