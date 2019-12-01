package d1;
/**
 * @author Alexander Karg
 */

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {

    /**
     * Klassenattribut
     */
    private static PersonenContentHandler pch = new PersonenContentHandler();

    /**
     * Programmeinstiegspunkt
     * @param args0
     */
    public static void main(String[] args0){
        //Abfrage danach was getan werden soll
        Scanner tastatur = new Scanner(System.in);
        boolean beenden = false;
        while(!beenden){
            System.out.println("Was soll getan werden?");
            System.out.println("Nur die Zahl eingeben");
            System.out.println("1. Lesen");
            System.out.println("2. Schreiben");
            System.out.println("3. Neue Person hinzufügen");
            System.out.println("4. Beenden");
            String eingabe = tastatur.nextLine();
            switch(eingabe){
                case "1":{
                    Program.readFromXML();
                    break;
                }
                case "2":{
                    Program.writeToXML();
                    break;
                }
                case "4":{
                    beenden = true;
                    break;
                }
                case "3":{
                    try{
                        addPerson();
                    }catch(ParseException e){
                        //Fehlerbehandlung wenn geburtsdatum oder Postleitzahl fasch
                        System.out.println("Geburtsdatum nicht richtig eingegeben");
                    }catch(NumberFormatException e){
                        System.out.println("Postleitzahl nicht richtig eingegeben");
                    }
                }
            }
        }
    }

    /**
     * Methode zum lesen der XML datei
     */
    private static void readFromXML(){
        try (FileReader reader = new FileReader("Personen.xml")) {
            //Quelle usw werden angegeben
            InputSource is = new InputSource(reader);
            XMLReader xmlreader = XMLReaderFactory.createXMLReader();
            //zu verwenden Contenthandler
            xmlreader.setContentHandler(pch);
            //aufrufen der Parsemethode zum parsen der XML datei
            xmlreader.parse(is);
        }catch(IOException | SAXException e){
            e.printStackTrace();
        }
    }

    /**
     * Methode zum erstellen einer neuen Person
     * @throws ParseException
     */
    private static void addPerson() throws ParseException {
        Scanner tastatur = new Scanner(System.in);
        //Abfrage nach Persondaten
        Person neu = new Person();
        System.out.println("Bitte den vornamen eingeben");
        neu.setVorname(tastatur.nextLine());
        System.out.println("Bitte den nachname eingeben");
        neu.setName(tastatur.nextLine());
        System.out.println("Bitte das Geburtstdatum eingeben");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        java.util.Date tmp = sdf.parse(tastatur.nextLine());
        neu.setGeburtstdatum(tmp);
        System.out.println("Bitte die Postleitzahl eingeben");
        neu.setPostleitzahl(Integer.parseInt(tastatur.nextLine()));
        System.out.println("Bitte den Ort eingeben");
        neu.setOrt(tastatur.nextLine());
        System.out.println("Bitte das Hobby eingeben");
        neu.setHobby(tastatur.nextLine());
        System.out.println("Bitte die Lieblingsfarbe eingeben");
        neu.setLieblingsfarbe(tastatur.nextLine());
        System.out.println("Bitte den Lieblingsfilm eingeben");
        neu.setLieblingsfilm(tastatur.nextLine());

        //erstellen der neuen ID
        //die höchte bisher verwendete ID wird um 1 hochgezählt
        int highestid = 0;
        for(Person p:Program.pch.getPersonen()){
            if(highestid<=p.getId()){
                highestid = p.getId()+1;
            }
        }

        //Setzen der ID
        neu.setId(highestid);
        Program.pch.getPersonen().add(neu);
    }

    /**
     * Methode zum ausgeben der XML struktur auf der Console
     */
    private static void writeToXML(){
        //Soll das jetzt auch ins xml doc geschreiben werden oder nur fix in der ArrayList gehalten?
        ArrayList<Person> tmp = Program.pch.getPersonen();

        //über PersonArray aus dem Contenthandler Iterrieren um Daten auszugeben
        for(Person p : Program.pch.getPersonen()){
            System.out.println("<person id="+p.getId()+">");
            System.out.println("<name>"+p.getName()+"</name>");
            System.out.println("<vorname>"+p.getVorname()+"</vorname>");
            System.out.println("<geburtsdatum>"+p.getGeburtstdatum()+"</geburtsdatum>");
            System.out.println("<postleitzahl>"+p.getPostleitzahl()+"</postleitzahl>");
            System.out.println("<ort>"+p.getOrt()+"</ort>");
            System.out.println("<hobby>"+p.getHobby()+"</hobby>");
            System.out.println("<lieblingsfarbe>"+p.getLieblingsfarbe()+"</lieblingsfarbe>");
            System.out.println("<lieblingsfilm>"+p.getLieblingsfilm()+"</lieblingsfilm>");

        }
    }
}
