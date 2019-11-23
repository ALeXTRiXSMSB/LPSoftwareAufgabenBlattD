package d1;

import java.util.Date;

public class Person {

    private int id;
    private String name;
    private String vorname;
    private Date geburtstdatum;
    private int postleitzahl;
    private String ort;
    private String hobby;
    private String lieblingsfarbe;
    private String lieblingsfilm;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public Date getGeburtstdatum() {
        return geburtstdatum;
    }

    public void setGeburtstdatum(Date geburtstdatum) {
        this.geburtstdatum = geburtstdatum;
    }

    public int getPostleitzahl() {
        return postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLieblingsfarbe() {
        return lieblingsfarbe;
    }

    public void setLieblingsfarbe(String lieblingsfarbe) {
        this.lieblingsfarbe = lieblingsfarbe;
    }

    public String getLieblingsfilm() {
        return lieblingsfilm;
    }

    public void setLieblingsfilm(String lieblingsfilm) {
        this.lieblingsfilm = lieblingsfilm;
    }
}
