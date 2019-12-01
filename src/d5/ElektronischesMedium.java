package d5;
/**
 * @author Alexander Karg
 */
import java.util.Date;

/**
 * Klasse ElektronischesMedium die von der Abstrakten Klasse Medium Erbt
 */
public class ElektronischesMedium extends Medium{

    /**
     * Klassenattribute
     */
    private String url;
    private Buch buch;
    private Date lastChange;


    /**
     * Konstruktor zum Erstellen von einem Objekt ElektronischesMedium
     * @param _titel
     * @param _url
     */
    public ElektronischesMedium(String _titel, String _url) {
        super(_titel);
        this.setUrl(_url);
    }

    /**
     * Überschriebener KOnstruktor zum erstellen eines Elektronischen Mediums das ein buch ist
     * @param _title
     */
    public ElektronischesMedium(String _title){
        super(_title);
        this.buch = new Buch(_title);
    }

    public void setBuch(Buch buch) {
        this.buch = buch;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }

    public Buch getBuch() {
        return buch;
    }

    /**
     * Gettermethode für das Attribut url
     * @return
     */
    public String getUrl() {
        return url;
    }

    /**
     * Settermethode für das Attribut url
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * methode zum überprüfen einer URL
     * @param url
     * @return
     */
    public boolean checkURL(String url){
        return true;
    }

    /**
     * Geerbte Funktion zum Ausgeben der Daten vom Medium
     * Werte Werden aus den Klassenattributen mittels Objekt vom Typ StringBuilder hinter einander gehängt
     * und dann als String formatiert und zurückgegeben
     * @return String
     */
    public String calculateRepresentation() {
        StringBuilder rueckgabe = new StringBuilder();
        //überprüfen ob es sich um Elektronisches Buch handelt
        if(this.buch != null){
            rueckgabe.append("Letzte Änderung: " + this.lastChange.toString()+System.lineSeparator()).append("Urheber: "+this.buch.getVerfasser());
        }else{
            rueckgabe.append(super.calculateRepresentation() + " ")
                    .append("URL: " + this.getUrl());
        }
        return rueckgabe.toString();
    }
}
