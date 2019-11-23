package d1;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args0){
        Scanner tastatur = new Scanner(System.in);
        boolean beenden = false;
        while(!beenden){
            System.out.println("Was soll getan werden?");
            System.out.println("Nur die Zahl eingeben");
            System.out.println("1. Lesen");
            System.out.println("2. Schreiben");
            System.out.println("3. Beenden");
            String eingabe = tastatur.nextLine();
            switch(eingabe){
                case "1":{
                    Program.readFromXML();
                }
                case "2":{
                    Program.writeToXML();
                }
                case "3:":{
                    beenden = true;
                }
            }
        }
    }

    private static void readFromXML(){
        try (FileReader reader = new FileReader("Personen.xml")) {
            InputSource is = new InputSource(reader);
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            xmlreader.setContentHandler(new PersonenContentHandler());
            xmlreader.parse(is);
        }catch(IOException | SAXException e){
            e.printStackTrace();
        }
    }

    private static void writeToXML(){
        //Soll das jetzt auch ins xml doc geschreiben werden oder nur fix in der ArrayList gehalten?
        PersonenContentHandler pch = new PersonenContentHandler();
        Person tmp = new Person();

    }
}
