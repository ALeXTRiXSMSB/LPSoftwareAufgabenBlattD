/**
 * @author Alexander Karg
 */
package d5;

/**
 * Klasse Zeitschrift die von der Abstrakten Klasse Medium Erbt
 */
public class Zeitschrift extends Medium {

    /**
     * Klassenattribute
     */
    private String issn;
    private String volume;
    private int nummer;

    /**
     * Konstruktor zum Erstellen von einem Objekt Zeitschrift
     *
     * @param _titel
     * @param _issn
     * @param _volume
     * @param _nummer
     */
    public Zeitschrift(String _titel, String _issn, String _volume, int _nummer) {
        super(_titel);
        this.setIssn(_issn);
        this.setVolume(_volume);
        this.setNummer(_nummer);
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut issn
     *
     * @return String
     */
    public String getIssn() {
        return issn;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut issn
     *
     * @param issn
     */
    public void setIssn(String issn) {
        this.issn = issn;
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut volume
     *
     * @return String
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut volume
     *
     * @param volume
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut nummer
     *
     * @return int
     */
    public int getNummer() {
        return nummer;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut nummer
     *
     * @param nummer
     */
    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    /**
     * Geerbte Funktion zum Ausgeben der Daten vom Medium
     * Werte Werden aus den Klassenattributen mittels Objekt vom Typ StringBuilder hinter einander gehängt
     * und dann als String formatiert und zurückgegeben
     *
     * @return String
     */
    @Override
    public String calculateRepresentation() {
        StringBuilder rueckgabe = new StringBuilder();
        rueckgabe.append(super.calculateRepresentation() + " ")
                .append("ISSN: " + this.getIssn() + " ")
                .append("Volume: " + this.getVolume() + " ")
                .append("Nummer:" + this.getNummer());
        return rueckgabe.toString();
    }
}