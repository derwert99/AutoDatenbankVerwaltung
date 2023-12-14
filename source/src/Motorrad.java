public class Motorrad  extends Zweirad {

    private String Kraftstoff;

    private String Getriebe;

    private int ps;

    public Motorrad(String farbe, String kraftstoff, String getriebe, int ps) {
        super(farbe);
        Kraftstoff = kraftstoff;
        Getriebe = getriebe;
        this.ps = ps;
    }

    public String getKraftstoff() {
        return Kraftstoff;
    }

    public void setKraftstoff(String kraftstoff) {
        Kraftstoff = kraftstoff;
    }

    public String getGetriebe() {
        return Getriebe;
    }

    public void setGetriebe(String getriebe) {
        Getriebe = getriebe;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }
}
