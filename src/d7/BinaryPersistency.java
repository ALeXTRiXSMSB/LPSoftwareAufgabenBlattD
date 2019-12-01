package d7;

import java.io.*;

public class BinaryPersistency implements Persistency {

    /**
     *
     * @param zk
     * @param dateiname
     */
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(dateiname));
            oos.writeObject(zk);
            oos.flush();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dateiname
     * @return
     */
    @Override
    public Zettelkasten load(String dateiname) {
        ObjectInputStream ois;
        try {
            ois = new ObjectInputStream(new FileInputStream(dateiname));
            Object o = ois.readObject();
            ois.close();
            if(o.getClass() == Zettelkasten.class){
                return (Zettelkasten)o;
            }else{
                return null;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
