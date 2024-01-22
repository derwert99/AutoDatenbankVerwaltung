public class Automodell extends Automarke {

    private String kennzeichen;
    private String modell;

    public Automodell(String kennzeichen, String marke, String modell, String farbe, int ps, String kraftstoff, String getriebe) {
        super(farbe, kraftstoff, getriebe, ps, marke);
        this.kennzeichen = kennzeichen;
        this.modell = modell;
    }

    public String getKennzeichen() {
        return kennzeichen;
    }

    public String getModell() {
        return modell;
    }

    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }
}
