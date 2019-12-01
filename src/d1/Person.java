package d1;
/**
 * @author Alexander Karg
 */
import java.util.Date;

public class Person {

    /**
     * Klassenattribute
     */
    private int id;
    private String name;
    private String vorname;
    private Date geburtstdatum;
    private int postleitzahl;
    private String ort;
    private String hobby;
    private String lieblingsfarbe;
    private String lieblingsfilm;

    /**
     * Gettermethode ID
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * Settermethode ID
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gettermethode name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Settermethode name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gettermethode vorname
     * @return
     */
    public String getVorname() {
        return vorname;
    }

    /**
     * settermethode vorname
     * @param vorname
     */
    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    /**
     * gettermethode geburtstdatum
     * @return
     */
    public Date getGeburtstdatum() {
        return geburtstdatum;
    }

    /**
     * settermethode Geburtstatum
     * @param geburtstdatum
     */
    public void setGeburtstdatum(Date geburtstdatum) {
        this.geburtstdatum = geburtstdatum;
    }

    /**
     * gettermethode postleitzahl
     * @return
     */
    public int getPostleitzahl() {
        return postleitzahl;
    }

    /**
     * settermethode Postleitzahl
     * @param postleitzahl
     */
    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    /**
     * gettermethode ort
     * @return
     */
    public String getOrt() {
        return ort;
    }

    /**
     * settermethode ort
     * @param ort
     */
    public void setOrt(String ort) {
        this.ort = ort;
    }

    /**
     * gettermethode hobby
     * @return
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * settermethode hobby
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * gettermethode lieblingsfarbe
     * @return
     */
    public String getLieblingsfarbe() {
        return lieblingsfarbe;
    }

    /**
     * settermethode lieblingsfarbe
     * @param lieblingsfarbe
     */
    public void setLieblingsfarbe(String lieblingsfarbe) {
        this.lieblingsfarbe = lieblingsfarbe;
    }

    /**
     * gettermethode lieblingsfilm
     * @return
     */
    public String getLieblingsfilm() {
        return lieblingsfilm;
    }

    /**
     * settermethode lieblingsfilm
     * @param lieblingsfilm
     */
    public void setLieblingsfilm(String lieblingsfilm) {
        this.lieblingsfilm = lieblingsfilm;
    }
}
