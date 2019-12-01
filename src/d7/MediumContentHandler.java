package d7;
/**
 * @author Alexander Karg
 */
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;

/**
 * Bonus aufgabe nicht weiter bearbeitet
 */
public class MediumContentHandler implements ContentHandler {

    private String currentvalue;
    private Medium currentMedium;


    @Override
    public void setDocumentLocator(Locator locator) {

    }

    @Override
    public void startDocument() throws SAXException {

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
        if(s1.equals("medium")){
            if(attributes.getValue("type").equals("Buch")){
                currentMedium = new Buch("");
            }else if(attributes.getValue("type").equals("CD")){
                currentMedium = new CD("","","");
            }else if(attributes.getValue("type").equals("ElektronischesMedium")){
                currentMedium = new ElektronischesMedium("");
            }else if(attributes.getValue("type").equals("Zeitschrift")){
                currentMedium = new Zeitschrift("","","",0);
            }
        }
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {

    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        currentvalue = new String(chars,i,i1);
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
