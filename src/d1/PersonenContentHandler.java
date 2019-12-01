package d1;
/**
 * @author Alexander Karg
 */
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 */
public class PersonenContentHandler implements ContentHandler {

    /**
     * Klassenattribute
     */
    private ArrayList<Person> personen = new ArrayList<>();
    private Person currentPerson;
    private String currentValue;

    /**
     * Gettermethode Person ArrayList
     * @return
     */
    public ArrayList<Person> getPersonen() {
        return personen;
    }

    /**
     * Settermethode Person ArrayList
     * @param personen
     */
    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }

    /**
     * Gettermethode für Person
     * @return
     */
    public Person getCurrentPerson() {
        return currentPerson;
    }

    /**
     * Settermethode für Person
     * @param currentPerson
     */
    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    /**
     * Gettermethode für currentvalue
     * @return
     */
    public String getCurrentValue() {
        return currentValue;
    }

    /**
     * Gettermethode für currentValue
     * @param currentValue
     */
    public void setCurrentValue(String currentValue) {
        this.currentValue = currentValue;
    }

    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

    }

    @Override
    public void declaration(String version, String encoding, String standalone) throws SAXException {

    }

    @Override
    public void endDocument() throws SAXException {

    }

    @Override
    public void startPrefixMapping(String s, String s1) throws SAXException {

    }

    @Override
    public void endPrefixMapping(String s) throws SAXException {

    }

    /**
     * Methode triggert wenn ein start tag in der XML datei aufgerufen wird
     * @param s
     * @param s1
     * @param s2
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        //Abfrage ob gerade gelesenen TAG person heißt damit ein Objekt Person mit einer bestimmten id erstellt wird
        //id wird vom Attribut des TAGs genommen
        if(s1.equals("person")){
            currentPerson = new Person();
            currentPerson.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    /**
     * Methode triggert wenn ein Endelement in der XML datei aufgerufen wird
     * @param s
     * @param s1
     * @param s2
     * @throws SAXException
     */
    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        //fallunterscheidung der tags zum setzen der werte aus der XML datei in das Objekt currentperson
        switch(s1){
            case "name":{
                currentPerson.setName(currentValue);
                break;
            }
            case "vorname":{
                currentPerson.setVorname(currentValue);
                break;
            }
            case "geburtsdatum":{
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    Date tmp = sdf.parse(currentValue);
                    currentPerson.setGeburtstdatum(tmp);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "postleitzahl":{
                currentPerson.setPostleitzahl(Integer.parseInt(currentValue));
                break;
            }
            case "ort":{
                currentPerson.setOrt(currentValue);
                break;
            }
            case "hobby":{
                currentPerson.setHobby(currentValue);
                break;
            }
            case "lieblingsfarbe":{
                currentPerson.setLieblingsfarbe(currentValue);
                break;
            }
            case "lieblingsfilm":{
                currentPerson.setLieblingsfilm(currentValue);
                break;
            }
            case "person":{
                //wenn person wieder auftaucht wird das objekt currentperson an die Arraylist angefügt
                personen.add(currentPerson);
                break;
            }
        }
    }

    /**
     * Methode zum speichern der aktuellen strings aus der XML datei
     * @param chars
     * @param i
     * @param i1
     * @throws SAXException
     */
    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        //zuweisung des aktuellen Strings der gerade gelesen wird
        currentValue = new String(chars,i,i1);
    }

    @Override
    public void ignorableWhitespace(char[] chars, int i, int i1) throws SAXException {

    }

    @Override
    public void processingInstruction(String s, String s1) throws SAXException {

    }

    @Override
    public void skippedEntity(String s) throws SAXException {

    }
}
