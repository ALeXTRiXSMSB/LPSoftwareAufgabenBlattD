package d5;
/**
 * @author Alexander Karg
 */
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class WikibooksContentHandler implements ContentHandler {

    /**
     * Klassenattribute
     */
    private String currentValue;
    private ElektronischesMedium currentMedium;

    public ElektronischesMedium getCurrentMedium(){
        return this.currentMedium;
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
     * methode triggert wenn start tag erreicht wird
     * @param s
     * @param s1
     * @param s2
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String s, String s1, String s2, Attributes attributes) throws SAXException {
        if(s1.equals("title")){
            //neues Objekt erstellen wenn start tag = title
           this.currentMedium = new ElektronischesMedium(currentValue);
        }
    }

    /**
     * methode triggert wenn endtag erreicht wird
     * @param s
     * @param s1
     * @param s2
     * @throws SAXException
     */
    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        //fallunterscheidung der endtags
        switch(s1){
            case "title":{
                this.currentMedium.setTitel(currentValue);
                this.currentMedium.getBuch().setTitel(currentValue);
                break;
            }
            case "timestamp":{
                //datum wird geparst mit simpledateformat
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                try {
                    Date timestamp = sdf.parse(this.currentValue);
                    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
                    cal.setTime(timestamp);
                    this.currentMedium.getBuch().setErscheinungsjahr(cal.get(Calendar.YEAR));
                    this.currentMedium.setLastChange(cal.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "username":{
                this.currentMedium.getBuch().setVerfasser(this.currentValue);
                break;
            }
        }
    }

    /**
     * methode schreibt den aktuellen wert in variable für spätere verwendung
     * @param chars
     * @param i
     * @param i1
     * @throws SAXException
     */
    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        this.currentValue = new String(chars,i,i1);
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
