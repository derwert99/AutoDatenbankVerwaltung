public class Motorradmarke extends Motorrad {

    private String marke;

    public Motorradmarke(String farbe, String kraftstoff, String getriebe, int ps, String marke) {
        super(farbe, kraftstoff, getriebe, ps);
        this.marke = marke;
    }

    public String getMarke() {
        return marke;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }
}
