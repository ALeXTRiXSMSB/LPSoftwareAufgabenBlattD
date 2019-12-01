package d7;

import java.util.ArrayList;

public class WikiBuch {

    private ElektronischesMedium url;
    private String regal;
    private ArrayList<String> kapitel = new ArrayList<String>();

    public WikiBuch(String titel){
        this.url = new ElektronischesMedium(titel);
    }

    public ElektronischesMedium getUrl() {
        return url;
    }

    public void setUrl(ElektronischesMedium url) {
        this.url = url;
    }

    public String getRegal() {
        return regal;
    }

    public void setRegal(String regal) {
        this.regal = regal;
    }

    public ArrayList<String> getKapitel() {
        return kapitel;
    }

    public void setKapitel(ArrayList<String> kapitel) {
        this.kapitel = kapitel;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append("Regal: "+this.regal+System.lineSeparator());
        sb.append("Kapitel"+System.lineSeparator());
        int count = 1;
        for(String s:this.kapitel){
            sb.append(count+ " "+s+System.lineSeparator());
            count++;
        }
        sb.append(this.url.calculateRepresentation());
        System.out.println(sb.toString());
    }
}
