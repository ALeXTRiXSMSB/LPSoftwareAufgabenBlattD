package d3;
/**
 * @author Alexander Karg
 */
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

import java.util.ArrayList;

public class ItemContentHandler implements ContentHandler {

    /**
     * klassenattribute
     */
    private ArrayList<Item> news = new ArrayList<>();
    private Item currentItem;
    private String currentValue;

    public ArrayList<Item> getNews() {
        return news;
    }

    public void setNews(ArrayList<Item> news) {
        this.news = news;
    }

    public Item getCurrentItem() {
        return currentItem;
    }

    public void setCurrentItem(Item currentItem) {
        this.currentItem = currentItem;
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
        //wenn start tag item oder channel dann wird ein neues objekt item erstellt
        if(s1.equals("item") || s1.equals("channel")){
            currentItem = new Item();
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
        //fallunterscheidung zum zuweisen des tags an das richtige attribut im Objekt
        switch(s1){
            case "title":{
                currentItem.setTitel(currentValue);
                break;
            }
            case "link":{
                currentItem.setUrl(currentValue);
                break;
            }
            case "description":{
                currentItem.setBeschreibung(currentValue);
                break;
            }
            case "item":{
                //wenn end tag = item dann wird objekt an arraylist angefügt
                news.add(currentItem);
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
