package d4;

public class Person {
    private String vorname;
    private String nachname;
    private String alias;

    public Person(String vorname, String nachname, String alias) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.alias = alias;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    private void calculateRepresentations(){
        System.out.println(this.vorname + " " + this.nachname + " - " + this.alias);
    }
}
