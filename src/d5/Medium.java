/**
 * @author Alexander Karg
 */
package d5;

/**
 * Abstrakteklasse von der die unterklassen Methoden Erben
 */
public abstract class Medium implements Comparable<Medium>{
    /**
     * Klassenattribut
     */
    private String titel;

    /**
     * Konstruktor zum erstellen von einem Objekt Medium
     *
     * @param _titel
     */
    public Medium(String _titel) {
        this.setTitel(_titel);
    }

    /**
     * Getter Methode zum abrufen des Wert im Attribut titel
     *
     * @return String
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Setter Methode zum setzen des Wert im Attribut titel
     *
     * @param titel
     */
    public void setTitel(String titel) {
        this.titel = titel;
    }

    /**
     * Abstrakte Methode ohne Programm Logik
     * Abstrakte Methoden werden an alle "Kinder" vererbt und müssen in in den "Kinder" klassen mit der Logik
     * gefüllt werden Logik kann sich bei mehreren "Kindern" unterscheiden
     *
     * @return String
     */
    public String calculateRepresentation(){
        StringBuilder sb = new StringBuilder();
        sb.append("Titel: ").append(this.getTitel());
        return sb.toString();
    }

    public int compareTo(Medium m){
        if(this.titel.equals(m.getTitel())){
            return this.getClass().toString().compareTo(m.getClass().toString());
        }
        return this.titel.compareTo(m.getTitel());
    }
}