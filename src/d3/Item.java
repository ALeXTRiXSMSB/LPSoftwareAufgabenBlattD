package d3;

public class Item {

    private String titel;
    private String url;
    private String beschreibung;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public void calculateRepresentaion(){
        System.out.println(this.getTitel());
        System.out.println(this.getBeschreibung());
        System.out.println(this.getUrl());
        System.out.println("");
    }
}
