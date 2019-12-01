package d7;

public class Buch extends Medium {

    /**
     *
     */
    private int erscheinungsjahr;
    private String verlag;
    private String isbn;
    private String verfasser;

    /**
     *
     * @param _titel
     * @param _erscheinungsjahr
     * @param _verlag
     * @param _isbn
     * @param _verfasser
     */
    public Buch(String _titel, int _erscheinungsjahr, String _verlag, String _isbn, String _verfasser) {
        super(_titel);
        this.setErscheinungsjahr(_erscheinungsjahr);
        this.setIsbn(_isbn);
        this.setVerfasser(_verfasser);
        this.setVerlag(_verlag);
    }

    public Buch(String _title){
        super(_title);
    }

    /**
     *
     * @return
     */
    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    /**
     *
     * @param erscheinungsjahr
     */
    public void setErscheinungsjahr(int erscheinungsjahr) {
        this.erscheinungsjahr = erscheinungsjahr;
    }

    /**
     *
     * @return
     */
    public String getVerlag() {
        return verlag;
    }

    /**
     *
     * @param verlag
     */
    public void setVerlag(String verlag) {
        this.verlag = verlag;
    }

    /**
     *
     * @return
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     *
     * @param isbn
     */
    public void setIsbn(String isbn) {
        int laengeisbn = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (Character.isDigit(isbn.toCharArray()[i])) {
                laengeisbn++;
            }
        }
        int[] isbnarr = new int[laengeisbn];
        int count = 0;
        for (int i = 0; i < isbn.length(); i++) {
            if (Character.isDigit(isbn.toCharArray()[i])) {
                isbnarr[count] = ((int) isbn.charAt(i) - 48);
                count++;
            }
        }
        switch (laengeisbn) {
            case 10: {
                if (Buch.checkISBN10(isbnarr)) {
                    this.isbn = isbn;
                } else {
                    System.out.println("ISBN-10 Ist Fehlerhaft und wird als / gespeichert um später noch änderungen zu machen");
                    this.isbn = "/";
                }
                break;
            }
            case 13: {
                if (Buch.checkISBN13(isbnarr)) {
                    this.isbn = isbn;
                } else {
                    System.out.println("ISBN-13 Ist Fehlerhaft und wird als / gespeichert um später noch änderungen zu machen");
                    this.isbn = "/";
                }
                break;
            }
            default: {
                System.out.println("ISBN Hat die Falsche Länge und wird als / gespeichert um Später noch änderungen zu machen");
                this.isbn = "/";
            }
        }
    }

    /**
     *
     * @return
     */
    public String getVerfasser() {
        return verfasser;
    }

    /**
     *
     * @param verfasser
     */
    public void setVerfasser(String verfasser) {
        this.verfasser = verfasser;
    }

    /**
     *
     * @param isbn
     * @return
     */
    public static boolean checkISBN10(int[] isbn) {
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        return sum % 11 == 0;
    }

    /**
     *
     * @param isbn
     * @return
     */
    public static boolean checkISBN13(int[] isbn) {
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        return isbn[isbn.length - 1] == check;
    }

    /**
     *
     * @return
     */
    public String calculateRepresentation() {
        StringBuilder rueckgabe = new StringBuilder();
        rueckgabe.append(super.calculateRepresentation() + " ")
                .append("Erscheinungsjahr: " + this.getErscheinungsjahr() + " ")
                .append("Verlag: " + this.getVerlag() + " ")
                .append("ISBN: " + this.getIsbn() + " ")
                .append("Verfasser: " + this.getVerfasser());
        return rueckgabe.toString();
    }
}