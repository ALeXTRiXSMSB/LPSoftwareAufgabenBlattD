package d5;
/**
 * @author Alexander Karg
 */
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import java.util.ArrayList;

public class DatabasePersistency implements Persistency {

    /**
     * Klassenattribute
     */
    private ObjectContainer db;

    /**
     * Methide zum speichern eines Zettelkastens
     * @param zk
     * @param dateiname
     */
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        //DB4o Datei wird ersetellt
        this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),dateiname);
        //zettelkasten objekt wird in der datei gespeichert
        db.store(zk);
        //Stream wird geschlossen
        db.close();
    }

    /**
     * Methode zum laden des letzten Zettelkastens
     * @param dateiname
     * @return
     */
    @Override
    public Zettelkasten load(String dateiname) {
        this.db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(),dateiname);
        //Anfrage an die DB4o datenbank ob Zettelkasten objekt vorhanden ist
        ObjectSet ergebnis = this.db.queryByExample(Zettelkasten.class);
        Zettelkasten zk = new Zettelkasten();
        ArrayList<Zettelkasten> tmp = new ArrayList<>();
        int i = 0;
        for(Object o : ergebnis){
            if(o.getClass() ==Zettelkasten.class){
                tmp.add((Zettelkasten)o);
            }else{
                System.out.println("Unbekannter Datentyp in der Datenbank an der stelle: "+i);
            }
            i++;
        }
        db.close();
        //Einfach erstmal immer nur die letzte version laden
        return tmp.get(tmp.size()-1);
    }
}
