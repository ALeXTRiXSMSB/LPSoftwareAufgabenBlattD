package d7;
/**
 * @author Alexander Karg
 */
public interface Persistency {

    /**
     * MEthode zum Speichern eines Zettelkastens
     * @param zk
     * @param dateiname
     */
    void save(Zettelkasten zk, String dateiname);

    /**
     * Methode zum Laden eines Zettelkastens
     * @param dateiname
     * @return
     */
    Zettelkasten load(String dateiname);
}
