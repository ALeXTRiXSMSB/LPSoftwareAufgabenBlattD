/**
 * @author Alexander Karg
 */
package d7;

/**
 * Klasse CD die von der Abstrakten Klasse Medium Erbt
 */
public class CD extends Medium {

    /**
     * Klassenattribute
     */
    private String label;
    private String kuenstler;

    /**
     * Konstruktor zum Erstellen von einem Objekt CD
     *
     * @param _titel
     * @param _label
     * @param _kuenstler
     */
    public CD(String _titel, String _kuenstler,String _label) {
        super(_titel);
        this.setLabel(_label);
        this.setKuenstler(_kuenstler);
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut kuenstler
     *
     * @return String
     */
    public String getKuenstler() {
        return kuenstler;
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut label
     *
     * @return String
     */
    public String getLabel() {
        return label;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut kuenstler
     *
     * @param kuenstler
     */
    public void setKuenstler(String kuenstler) {
        this.kuenstler = kuenstler;
    }

    /**
     * Setter Methode zum setzen eines Wertes im Attribut label
     *
     * @param label
     */
    public void setLabel(String label) {
        this.label = label;
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
                .append("Label: " + this.getLabel() + " ")
                .append("Künstler: " + this.getKuenstler() + " ");
        return rueckgabe.toString();
    }
}