package d1;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PersonenContentHandler implements ContentHandler {

    private ArrayList<Person> personen = new ArrayList<>();
    private Person currentPerson;
    private String currentValue;

    public ArrayList<Person> getPersonen() {
        return personen;
    }

    public void setPersonen(ArrayList<Person> personen) {
        this.personen = personen;
    }

    public Person getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Person currentPerson) {
        this.currentPerson = currentPerson;
    }

    public String getCurrentValue() {
        return currentValue;
    }

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

    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        if(s1.equals("person")){
            currentPerson = new Person();
            currentPerson.setId(Integer.parseInt(attributes.getValue("id")));
        }
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
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
                personen.add(currentPerson);
                break;
            }
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
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
