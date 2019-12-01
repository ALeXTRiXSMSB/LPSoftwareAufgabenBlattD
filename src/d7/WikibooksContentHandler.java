package d7;

import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class WikibooksContentHandler implements ContentHandler {

    private String currentValue;
    private WikiBuch wb;
    private boolean regal = false;


    public WikiBuch getCurrentBuch() {
        return this.wb;
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
        if (s1.equals("title")) {
            this.wb = new WikiBuch(currentValue);
        }
        if (s1.equals("s")) {
            String tmp = attributes.getValue("line");
            this.wb.getKapitel().add(tmp);
        }
        if(s1.equals("pl")){
            String tmp = attributes.getValue("ns");
            if(tmp.equals("102")){
                this.regal = true;
            }
        }
    }

    @Override
    public void endElement(String s, String s1, String s2) throws SAXException {
        switch (s1) {
            case "title": {
                this.wb.getUrl().setTitel(currentValue);
                this.wb.getUrl().getBuch().setTitel(currentValue);
                break;
            }
            case "timestamp": {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                try {
                    Date timestamp = sdf.parse(this.currentValue);
                    Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Berlin"));
                    cal.setTime(timestamp);
                    this.wb.getUrl().getBuch().setErscheinungsjahr(cal.get(Calendar.YEAR));
                    this.wb.getUrl().setLastChange(cal.getTime());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
            case "username": {
                this.wb.getUrl().getBuch().setVerfasser(this.currentValue);
                break;
            }
            case "pl":{
                if(regal){
                    this.wb.setRegal(currentValue.replace("Regal:",""));
                }
            }
        }
    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        this.currentValue = new String(chars, i, i1);
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
