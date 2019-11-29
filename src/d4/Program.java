package d4;

public class Program {

    public static void main(String[] args0){

        String vorname;
        String nachname;
        String alias;

        String xml = "<team>" +
                "<person><vorname>Norrin</vorname><nachname>Radd</nachname><alias>Silver " +
                "Surfer</alias></person>" +
                "<person><vorname>Ben</vorname><nachname>Grimm</nachname><alias>Das " +
                "Ding</alias></person></team>";
        System.out.println(xml);


        //änderungen im String vornehmen groß und klein schreibung verändern
        for(int i = 0; i < xml.length();i++){
            if(xml.charAt(i) == '<'){
                int j = i;
                while(xml.charAt(j) != '>'){
                    if(Character.isUpperCase(xml.charAt(j))){
                        xml = xml.replace(xml.charAt(j),Character.toLowerCase(xml.charAt(j)));
                    }
                    j++;
                }
            }
        }
        System.out.println(xml);

        //Fehler suche
        String xmlFehlerkorrektur = xml;
        int tagOpen  = 0;
        int tagClose = 0;
        for(int i = 0; i < xmlFehlerkorrektur.length();i++){
            if(xmlFehlerkorrektur.charAt(i) == '<'){
                tagOpen++;
            }
            if(xmlFehlerkorrektur.charAt(i) == '>'){
                tagClose++;
            }
        }
        if(tagOpen%2 == 0 && tagClose%2 == 0){
            //xml tag team vorne und hinten abschneiden
            xml = xml.substring(0,xml.length()-7);
            xml = xml.substring(6);
            //parsen
            while(xml.length() != 0){
                String xml2 = xml.substring(xml.indexOf("<person>")+8,xml.indexOf("</person>"));
                vorname = xml2.substring(xml2.indexOf("<vorname>")+9,xml2.indexOf("</vorname>"));
                nachname = xml2.substring(xml2.indexOf("<nachname>")+10,xml2.indexOf("</nachname>"));
                alias = xml2.substring(xml2.indexOf("<alias>")+7,xml2.indexOf("</alias>"));
                xml = xml.substring(xml.indexOf("</person>")+9);
                System.out.println(vorname + " " + nachname + " - " + alias);
            }
            System.out.println(xml);
        }else{
            System.out.println("Eingabe fehlerhaft");
        }
    }
}
