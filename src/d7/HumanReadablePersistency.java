package d7;
/**
 * @author Alexander Karg
 */
import java.io.*;

public class HumanReadablePersistency implements Persistency {

    /**
     * Überschriebene Methode zum Speichern eines Zettelkastens in Menschenlesbarem Format
     * @param zk
     * @param dateiname
     */
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        OutputStreamWriter osw = null;
        try {
            osw = new OutputStreamWriter(new FileOutputStream(dateiname),"UTF-8");
            for(Medium m:zk){
                osw.write(m.calculateRepresentation());
                osw.write(System.lineSeparator());
            }
            osw.flush();
            osw.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Überschriebene Methode zum Laden eines Zettelkastens aus einer Datei die Menschenlesbar gespeichert wurde
     * @param dateiname
     * @return
     */
    @Override
    public Zettelkasten load(String dateiname) {
        try{
            throw new UnsupportedOperationException();
        }catch(UnsupportedOperationException e){
            System.out.println("Methode noch nicht implementiert");
            return null;
        }
    }
}
