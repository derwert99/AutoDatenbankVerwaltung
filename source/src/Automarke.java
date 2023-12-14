public class Automarke extends Auto{

    private String automarke;

    public Automarke(String farbe, String kraftstoff, String getriebe, int ps, String automarke) {
        super(farbe, kraftstoff, getriebe, ps);
        this.automarke = automarke;
    }

    public String getAutomarke() {
        return automarke;
    }

    public void setAutomarke(String automarke) {
        this.automarke = automarke;
    }
}
