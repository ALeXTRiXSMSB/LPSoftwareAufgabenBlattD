package d2;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class Program {

    public static void main(String[] args){
        try{
            URL link = new URL("http://www.tagesschau.de/xml/rss2");
            URLConnection conn = link.openConnection();
            InputStream is = conn.getInputStream();
            int i = 0;
            while((i = is.read()) != -1){
                System.out.print((char)i);
            }



        } catch(IOException e){

        }
    }
}
