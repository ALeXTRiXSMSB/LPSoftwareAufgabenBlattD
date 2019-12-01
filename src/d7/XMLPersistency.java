package d7;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLPersistency implements Persistency {
    @Override
    public void save(Zettelkasten zk, String dateiname) {
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.newDocument();

            Element root = d.createElement("zettelkasten");
            d.appendChild(root);

            int count = 0;
            for(Medium m : zk){
                Element medium = d.createElement("medium");
                root.appendChild(medium);

                Attr id = d.createAttribute("id");
                id.setValue(String.valueOf(count));
                medium.setAttributeNode(id);

                Attr type = d.createAttribute("type");
                type.setValue(m.getClass().getSimpleName());
                medium.setAttributeNode(type);

                Element titel = d.createElement("titel");
                titel.appendChild(d.createTextNode(m.getTitel()));
                medium.appendChild(titel);

                if(m.getClass() == Buch.class){
                    Buch tmp = (Buch)m;

                    Element verfasser = d.createElement("verfasser");
                    verfasser.appendChild(d.createTextNode(tmp.getVerfasser()));

                    Element erscheinungsjahr = d.createElement("erscheinungsjahr");
                    erscheinungsjahr.appendChild(d.createTextNode(String.valueOf(tmp.getErscheinungsjahr())));

                    Element verlag = d.createElement("verlag");
                    verlag.appendChild(d.createTextNode(tmp.getVerlag()));

                    Element isbn = d.createElement("isbn");
                    isbn.appendChild(d.createTextNode(tmp.getIsbn()));

                    medium.appendChild(erscheinungsjahr);
                    medium.appendChild(verlag);
                    medium.appendChild(isbn);
                    medium.appendChild(verfasser);

                }else if(m.getClass() == CD.class){
                    CD tmp = (CD)m;

                    Element label = d.createElement("label");
                    label.appendChild(d.createTextNode(tmp.getLabel()));

                    Element kuenstler = d.createElement("kuenstler");
                    kuenstler.appendChild(d.createTextNode(tmp.getKuenstler()));

                    medium.appendChild(label);
                    medium.appendChild(kuenstler);

                }else if(m.getClass() == ElektronischesMedium.class){
                    ElektronischesMedium tmp = (ElektronischesMedium)m;

                    if(tmp.getBuch() != null){
                        Buch tmp2 = tmp.getBuch();
                        Element buch = d.createElement("buch");

                        Element buchTitel = d.createElement("titel");
                        buchTitel.appendChild(d.createTextNode(tmp.getTitel()));

                        Element verfasser = d.createElement("verfasser");
                        verfasser.appendChild(d.createTextNode(tmp2.getVerfasser()));

                        Element erscheinungsjahr = d.createElement("erscheinungsjahr");
                        erscheinungsjahr.appendChild(d.createTextNode(String.valueOf(tmp2.getErscheinungsjahr())));

                        buch.appendChild(buchTitel);
                        buch.appendChild(verfasser);
                        buch.appendChild(erscheinungsjahr);
                        medium.appendChild(buch);

                    }

                    Element url = d.createElement("url");
                    url.appendChild(d.createTextNode(tmp.getUrl()));

                    Element lastchange = d.createElement("lastchange");
                    lastchange.appendChild(d.createTextNode(tmp.getLastChange().toString()));

                    medium.appendChild(url);
                    medium.appendChild(lastchange);

                }else if(m.getClass() == Zeitschrift.class){
                    Zeitschrift tmp = (Zeitschrift)m;

                    Element issn = d.createElement("issn");
                    issn.appendChild(d.createTextNode(tmp.getIssn()));

                    Element volume = d.createElement("volume");
                    volume.appendChild(d.createTextNode(tmp.getVolume()));

                    Element nummer = d.createElement("nummer");
                    nummer.appendChild(d.createTextNode(String.valueOf(tmp.getNummer())));

                    medium.appendChild(issn);
                    medium.appendChild(volume);
                    medium.appendChild(nummer);
                }
                count++;
            }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            DOMSource ds = new DOMSource(d);
            StreamResult sr = new StreamResult(new File(dateiname));
            t.transform(ds,sr);

        }catch(ParserConfigurationException | TransformerConfigurationException e){
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Zettelkasten load(String dateiname) {

        return null;
    }
}
